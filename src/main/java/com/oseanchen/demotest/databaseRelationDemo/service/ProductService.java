package com.oseanchen.demotest.databaseRelationDemo.service;

import com.oseanchen.demotest.databaseRelationDemo.entity.Product;
import com.oseanchen.demotest.databaseRelationDemo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Product getProdctById(Long id) {
        return productRepository.findById(id);
    }

    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    public void deleteProductById(Long id) {
        productRepository.deleteById(id);
    }
}
