package com.platformstore.productAPI.Service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.platformstore.productAPI.Kafka.ProductSentEvent;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class KafkaMessagingService {

    @Value("${topic.send-order}")
    private String sendClientTopic;

    private final KafkaTemplate<String , Object> kafkaTemplate;

    public void sendOrder(ProductSentEvent productSendEvent) {
       kafkaTemplate.send(sendClientTopic, productSendEvent.getId(), productSendEvent);
    }
}
