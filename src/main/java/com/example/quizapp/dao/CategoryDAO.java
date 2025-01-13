package com.example.quizapp.dao;

import com.example.quizapp.model.Category;

import java.util.List;

public interface CategoryDAO {
    List<Category> findAll();
}
