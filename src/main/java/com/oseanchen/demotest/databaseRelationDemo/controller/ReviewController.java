package com.oseanchen.demotest.databaseRelationDemo.controller;

import com.oseanchen.demotest.databaseRelationDemo.entity.Review;
import com.oseanchen.demotest.databaseRelationDemo.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/api")
@RestController
public class ReviewController {
    @Autowired
    private ReviewRepository reviewRepository;

    @GetMapping("/reviews")
    public List<Review> findAll() {
        return reviewRepository.findAll();
    }
}
