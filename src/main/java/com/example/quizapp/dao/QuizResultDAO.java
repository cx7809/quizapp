package com.example.quizapp.dao;

import com.example.quizapp.model.QuizResult;

import java.util.List;

public interface QuizResultDAO {
    QuizResult findById(Long id);

    List<QuizResult> findAll();

    void save(QuizResult quizResult);

    void update(QuizResult quizResult);

    void delete(QuizResult quizResult);

    List<QuizResult> findByUserId(Long userId); // Custom method for finding results by user
}
