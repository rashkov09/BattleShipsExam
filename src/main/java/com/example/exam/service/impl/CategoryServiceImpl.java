package com.example.exam.service.impl;

import com.example.exam.model.entity.Category;
import com.example.exam.model.enums.CategoryName;
import com.example.exam.repository.CategoryRepository;
import com.example.exam.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }


    @Override
    public void initCategories() {
        if (categoryRepository.count() == 0) {
            Arrays.stream(CategoryName.values()).forEach(categoryName -> {
                Category category = new Category();
                category.setName(categoryName);
                category.setDescription("Some text");
                categoryRepository.save(category);
            });
        }
    }

    @Override
    public Category findCategoryByName(CategoryName category) {
        return categoryRepository.findByName(category);
    }
}
