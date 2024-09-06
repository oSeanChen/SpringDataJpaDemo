package com.oseanchen.demotest.databaseRelationDemo.repository;

import com.oseanchen.demotest.databaseRelationDemo.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<Tag, Long> {
}
