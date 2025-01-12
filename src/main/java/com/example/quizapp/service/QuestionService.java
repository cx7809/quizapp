package com.example.quizapp.service;

import com.example.quizapp.model.Question;

import java.util.List;

public interface QuestionService {
    Question findById(Long id);

    List<Question> findAll();

    void save(Question question);

    void update(Question question);

    void delete(Question question);

    List<Question> findByCategoryId(Long categoryId);
}
