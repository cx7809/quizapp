package com.example.quizapp.service;

import com.example.quizapp.model.Category;

import java.util.List;

public interface CategoryService {
    Category findById(Long id);

    List<Category> findAll();

    void save(Category category);

    void update(Category category);

    void delete(Category category);

    Category findByName(String name);
}
