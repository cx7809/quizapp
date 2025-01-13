package com.example.quizapp.dao;

import com.example.quizapp.model.Question;

import java.util.List;

public interface QuestionDAO {
    List<Question> findRandomQuestionsByCategoryId(Long categoryId);
    void save(Question question);
}
