package com.example.quizapp.controller;

import com.example.quizapp.model.Category;
import com.example.quizapp.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/{slug}")
    public String categoryPage(@PathVariable String slug, Model model) {
        Category category = categoryService.findBySlug(slug);
        model.addAttribute("category", category);
        return "category"; // Render category-specific JSP
    }
}
