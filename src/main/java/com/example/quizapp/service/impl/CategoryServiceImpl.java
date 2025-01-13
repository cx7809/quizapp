package com.example.quizapp.service.impl;

import com.example.quizapp.dao.CategoryDAO;
import com.example.quizapp.model.Category;
import com.example.quizapp.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryDAO categoryDAO;

    @Override
    public List<Category> getAllCategories() {
        return categoryDAO.findAll();
    }

    @Override
    public Category findBySlug(String slug) {
        return categoryDAO.findBySlug(slug);
    }

}
