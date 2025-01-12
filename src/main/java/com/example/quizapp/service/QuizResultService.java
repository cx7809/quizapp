package com.example.quizapp.service;

import com.example.quizapp.model.QuizResult;

import java.util.List;

public interface QuizResultService {
    QuizResult findById(Long id);

    List<QuizResult> findAll();

    void save(QuizResult quizResult);

    void update(QuizResult quizResult);

    void delete(QuizResult quizResult);

    List<QuizResult> findByUserId(Long userId); // Find results by user
}
