package services;

import org.modelmapper.ModelMapper;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import Models.Product;
import Models.ProductEvent;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@AllArgsConstructor
public class KafkaMessagingService {
    private static final String topicCreateOrder = "${topic.send-order}";
    private static final String kafkaConsumerGroupId = "${spring.kafka.consumer.group-id}";
    private final ProductService productService;
    private final ModelMapper modelMapper;

    @Transactional
    @KafkaListener(topics = topicCreateOrder, groupId = kafkaConsumerGroupId, properties = {"spring.json.value.default.type=com.example.consumer.service.messaging.event.OrderEvent"})
    public ProductEvent createOrder(ProductEvent productEvent) {
        log.info("Message consumed {}", productEvent);
        productService.saveProduct(modelMapper.map(productEvent, Product.class));
        return productEvent;
    }

}