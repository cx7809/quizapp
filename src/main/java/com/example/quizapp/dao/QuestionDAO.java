package com.example.quizapp.dao;

import com.example.quizapp.model.Question;

import java.util.List;

public interface QuestionDAO {
    void save(Question question);
    List<Question> getRandomQuestionsByCategory(String categorySlug, int limit);
}
