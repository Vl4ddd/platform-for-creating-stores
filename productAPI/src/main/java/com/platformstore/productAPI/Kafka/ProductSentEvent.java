package com.platformstore.productAPI.Kafka;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductSentEvent {

    private String id;

    private String name;

    private String description;

    private double price;

    private int quantity;
}
