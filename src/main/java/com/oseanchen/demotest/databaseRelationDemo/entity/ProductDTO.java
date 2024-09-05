package com.oseanchen.demotest.databaseRelationDemo.entity;

import lombok.Data;

@Data
public class ProductDTO {
    private Long id;
    private String name;
    private Double price;
    private String description;
    private ProductsDetailsDTO productDetail;
}
