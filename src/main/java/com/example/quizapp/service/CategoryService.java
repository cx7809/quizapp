package com.example.quizapp.service;

import com.example.quizapp.model.Category;

import java.util.List;

public interface CategoryService {
    List<Category> getAllCategories();
    Category findBySlug(String slug);
}
