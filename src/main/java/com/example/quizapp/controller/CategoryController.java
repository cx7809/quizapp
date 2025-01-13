package com.example.quizapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class CategoryController {

    @GetMapping("/category/{id}")
    public String categoryPage(@PathVariable Long id, Model model) {
        model.addAttribute("categoryId", id);
        return "category"; // View name
    }
}
