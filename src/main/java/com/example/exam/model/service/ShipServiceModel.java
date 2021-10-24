package com.example.exam.model.service;

import com.example.exam.model.entity.Category;
import com.example.exam.model.entity.User;
import com.example.exam.model.enums.CategoryName;

import java.time.LocalDate;

public class ShipServiceModel {
    private String name;
    private Long health;
    private Long power;
    private LocalDate created;
    private CategoryName category;
    private User user;

    public ShipServiceModel() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getHealth() {
        return health;
    }

    public void setHealth(Long health) {
        this.health = health;
    }

    public Long getPower() {
        return power;
    }

    public void setPower(Long power) {
        this.power = power;
    }

    public LocalDate getCreated() {
        return created;
    }

    public void setCreated(LocalDate created) {
        this.created = created;
    }

    public CategoryName getCategory() {
        return category;
    }

    public void setCategory(CategoryName category) {
        this.category = category;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
