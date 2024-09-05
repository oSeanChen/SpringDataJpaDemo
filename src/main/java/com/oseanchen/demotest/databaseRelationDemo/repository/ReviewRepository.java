package com.oseanchen.demotest.databaseRelationDemo.repository;

import com.oseanchen.demotest.databaseRelationDemo.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
}
