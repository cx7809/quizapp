package com.example.quizapp.service;

import com.example.quizapp.model.Question;

import java.util.List;

public interface QuestionService {
    void saveQuestion(Question question);
    List<Question> getRandomQuestionsByCategory(String categorySlug, int limit);
}
