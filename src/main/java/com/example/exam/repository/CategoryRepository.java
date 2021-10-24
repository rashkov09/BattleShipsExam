package com.example.exam.repository;

import com.example.exam.model.entity.Category;
import com.example.exam.model.enums.CategoryName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Long> {
    Category findByName(CategoryName name);
}
