package com.example.quizapp.controller;

import com.example.quizapp.model.Question;
import com.example.quizapp.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class QuizController {

    @Autowired
    private QuestionService questionService;

    @GetMapping("/category/{categoryId}")
    public String startQuiz(@PathVariable Long categoryId, Model model) {
        List<Question> questions = questionService.getRandomQuestionsByCategoryId(categoryId);
        model.addAttribute("questions", questions);
        return "quiz";
    }
}
