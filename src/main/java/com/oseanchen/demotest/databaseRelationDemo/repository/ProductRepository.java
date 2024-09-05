package com.oseanchen.demotest.databaseRelationDemo.repository;

import com.oseanchen.demotest.databaseRelationDemo.entity.Product;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    @EntityGraph(attributePaths = "productDetails")
    List<Product> findAll();

    @Query("SELECT p FROM Product p JOIN FETCH p.productDetails")
    List<Product> findAllWithDetails();
}
