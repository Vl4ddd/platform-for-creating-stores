package com.platformstore.productAPI.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.platformstore.productAPI.Entities.Product.Product;
import com.platformstore.productAPI.Kafka.Components.Producer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/products")
public class ProductSendController {

     private final Producer producer;

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public Product sendOrder(@RequestBody Product product) {
        log.info("Send order to kafka");
        producer.sendOrderEvent(product);
        return product;
    }
    
}
