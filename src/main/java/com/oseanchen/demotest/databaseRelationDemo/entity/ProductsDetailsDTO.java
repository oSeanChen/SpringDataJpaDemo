package com.oseanchen.demotest.databaseRelationDemo.entity;

import lombok.Data;

@Data
public class ProductsDetailsDTO {
    private String developer;
    private String publisher;
    private String releaseDate;
    private String languageSupport;
    private ProductDTOForDetails product;
}
