package com.example.quizapp.controller;

import com.example.quizapp.model.QuizResult;
import com.example.quizapp.service.QuizResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quiz-results")
public class QuizResultController {

    @Autowired
    private QuizResultService quizResultService;

    @GetMapping("/{id}")
    public QuizResult getQuizResultById(@PathVariable Long id) {
        return quizResultService.findById(id);
    }

    @GetMapping
    public List<QuizResult> getAllQuizResults() {
        return quizResultService.findAll();
    }

    @PostMapping
    public void createQuizResult(@RequestBody QuizResult quizResult) {
        quizResultService.save(quizResult);
    }

    @PutMapping("/{id}")
    public void updateQuizResult(@PathVariable Long id, @RequestBody QuizResult quizResult) {
        quizResult.setId(id);
        quizResultService.update(quizResult);
    }

    @DeleteMapping("/{id}")
    public void deleteQuizResult(@PathVariable Long id) {
        QuizResult quizResult = quizResultService.findById(id);
        quizResultService.delete(quizResult);
    }

    @GetMapping("/user/{userId}")
    public List<QuizResult> getQuizResultsByUserId(@PathVariable Long userId) {
        return quizResultService.findByUserId(userId);
    }
}
