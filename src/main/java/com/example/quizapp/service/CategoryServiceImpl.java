package com.example.quizapp.service;

import com.example.quizapp.dao.CategoryDAO;
import com.example.quizapp.model.Category;
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
    public Category findById(Long id) {
        return categoryDAO.findById(id);
    }

    @Override
    public List<Category> findAll() {
        return categoryDAO.findAll();
    }

    @Override
    public void save(Category category) {
        categoryDAO.save(category);
    }

    @Override
    public void update(Category category) {
        categoryDAO.update(category);
    }

    @Override
    public void delete(Category category) {
        categoryDAO.delete(category);
    }

    @Override
    public Category findByName(String name) {
        return categoryDAO.findByName(name);
    }
}
