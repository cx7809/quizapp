package com.example.quizapp.service.impl;

import com.example.quizapp.dao.QuestionDAO;
import com.example.quizapp.model.Question;
import com.example.quizapp.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private QuestionDAO questionDAO;

    @Override
    public List<Question> getRandomQuestionsByCategory(String categorySlug, int limit) {
        return questionDAO.getRandomQuestionsByCategory(categorySlug, limit);
    }

    @Override
    public void saveQuestion(Question question) {
        questionDAO.save(question);
    }
}
