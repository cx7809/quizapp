package com.example.quizapp.service.impl;

import com.example.quizapp.dao.QuestionDAO;
import com.example.quizapp.model.Question;
import com.example.quizapp.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private QuestionDAO questionDAO;

    @Override
    @Transactional
    public List<Question> getRandomQuestionsByCategoryId(Long categoryId) {
        return questionDAO.findRandomQuestionsByCategoryId(categoryId);
    }

    @Override
    @Transactional
    public void saveQuestion(Question question) {
        questionDAO.save(question);
    }
}
