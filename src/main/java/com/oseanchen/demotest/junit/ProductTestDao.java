package com.oseanchen.demotest.junit;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface ProductTestDao extends JpaRepository<ProductTest, Long> {

    public Optional<ProductTest> findByName(String name);

    ProductTest updateById(Long id, ProductTest productTest);
}
