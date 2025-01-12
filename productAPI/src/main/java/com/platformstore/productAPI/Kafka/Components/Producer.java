package com.platformstore.productAPI.Kafka.Components;

import org.springframework.stereotype.Component;
import org.modelmapper.ModelMapper; 

import com.platformstore.productAPI.Entities.Product.Product;
import com.platformstore.productAPI.Kafka.ProductSentEvent;
import com.platformstore.productAPI.Service.KafkaMessagingService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@RequiredArgsConstructor
public class Producer {

    private final KafkaMessagingService kafkaMessagingService;
    private final ModelMapper modelMapper;


    public Product sendOrderEvent(Product product) {
        kafkaMessagingService.sendOrder(modelMapper.map(product, ProductSentEvent.class));
        log.info("Send product from producer {}", product);
        return product;
    }
}