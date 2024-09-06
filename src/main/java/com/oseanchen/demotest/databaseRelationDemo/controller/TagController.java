package com.oseanchen.demotest.databaseRelationDemo.controller;

import com.oseanchen.demotest.databaseRelationDemo.entity.Tag;
import com.oseanchen.demotest.databaseRelationDemo.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TagController {
    @Autowired
    private TagRepository tagRepository;

    @GetMapping("/tags")
    public List<Tag> findAll() {
        return tagRepository.findAll();
    }


}
