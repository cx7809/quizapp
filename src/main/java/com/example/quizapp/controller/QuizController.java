package com.example.quizapp.controller;

import com.example.quizapp.model.Category;
import com.example.quizapp.model.Question;
import com.example.quizapp.model.Role;
import com.example.quizapp.model.User;
import com.example.quizapp.service.CategoryService;
import com.example.quizapp.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/quiz")
public class QuizController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private QuestionService questionService;

    @GetMapping("/{slug}")
    public String startQuiz(@PathVariable String slug, Model model, HttpSession session) {
        Category category = categoryService.getCategoryBySlug(slug);
        if (category == null) {
            return "error";
        }

        User user = (User) session.getAttribute("loggedInUser");
        if (user != null) {
            if (Role.USER.equals(user.getRole())) {
                List<Question> questions = questionService.getRandomQuestionsByCategory(slug, 5);
                model.addAttribute("category", category);
                model.addAttribute("questions", questions);
                return "quiz"; // User home view
            }
        }
        // If user is not logged in or role is invalid
        return "redirect:/login";
    }

    @PostMapping("/submit")
    public String submitQuiz(@RequestParam Map<String, String> answers, Model model) {
        model.addAttribute("message", "Quiz submitted successfully!");
        return "result";
    }
}
