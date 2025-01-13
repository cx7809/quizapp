package com.example.quizapp.service;

import com.example.quizapp.model.Question;

import java.util.List;

public interface QuestionService {
    List<Question> getRandomQuestionsByCategoryId(Long categoryId);
    void saveQuestion(Question question);
}
