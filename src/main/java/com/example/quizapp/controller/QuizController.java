package com.example.quizapp.controller;

import com.example.quizapp.model.Category;
import com.example.quizapp.model.Question;
import com.example.quizapp.service.CategoryService;
import com.example.quizapp.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/quiz")
public class QuizController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private QuestionService questionService;

    @GetMapping("/{slug}")
    public String startQuiz(@PathVariable String slug, Model model) {
        Category category = categoryService.getCategoryBySlug(slug);
        if (category == null) {
            return "error";
        }

        List<Question> questions = questionService.getRandomQuestionsByCategory(slug, 5);
        model.addAttribute("category", category);
        model.addAttribute("questions", questions);
        return "quiz";
    }
}
