package com.example.exam.init;

import com.example.exam.service.CategoryService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;

@Controller
public class InitializeData implements CommandLineRunner{
    private final CategoryService categoryService;

    public InitializeData(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @Override
    public void run(String... args) throws Exception {
        categoryService.initCategories();
    }
}
