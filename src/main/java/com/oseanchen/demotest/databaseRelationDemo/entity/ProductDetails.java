package com.oseanchen.demotest.databaseRelationDemo.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "product_details")
//@JsonIgnoreProperties("product")
public class ProductDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String developer;
    private String publisher;
    private String releaseDate;
    private String languageSupport;

//    @OneToOne(mappedBy = "productDetails")
//    private Product product;
}

