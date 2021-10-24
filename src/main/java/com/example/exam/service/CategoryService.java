package com.example.exam.service;

import com.example.exam.model.entity.Category;
import com.example.exam.model.enums.CategoryName;

public interface CategoryService {
    void initCategories();

    Category findCategoryByName(CategoryName category);
}
