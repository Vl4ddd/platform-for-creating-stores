package com.platformstore.productAPI.Entities.Product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product {

  
    private String id;

    private String name;

    private String description;

    private double price;

    private int quantity;
}