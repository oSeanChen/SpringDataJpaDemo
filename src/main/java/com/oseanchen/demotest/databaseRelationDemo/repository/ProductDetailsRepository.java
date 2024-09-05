package com.oseanchen.demotest.databaseRelationDemo.repository;

import com.oseanchen.demotest.databaseRelationDemo.entity.ProductDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductDetailsRepository extends JpaRepository<ProductDetails, Integer> {
}
