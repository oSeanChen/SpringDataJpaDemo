package com.oseanchen.demotest.databaseRelationDemo.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Table(name = "tags")
//@JsonIgnoreProperties({"products"})
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
//    @ManyToMany(mappedBy = "tags")
//    private Set<Product> products = new HashSet<>();
}
