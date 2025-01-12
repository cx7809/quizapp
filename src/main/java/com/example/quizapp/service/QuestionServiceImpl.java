package com.example.quizapp.service;

import com.example.quizapp.dao.QuestionDAO;
import com.example.quizapp.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private QuestionDAO questionDAO;

    @Override
    public Question findById(Long id) {
        return questionDAO.findById(id);
    }

    @Override
    public List<Question> findAll() {
        return questionDAO.findAll();
    }

    @Override
    public void save(Question question) {
        questionDAO.save(question);
    }

    @Override
    public void update(Question question) {
        questionDAO.update(question);
    }

    @Override
    public void delete(Question question) {
        questionDAO.delete(question);
    }

    @Override
    public List<Question> findByCategoryId(Long categoryId) {
        return questionDAO.findByCategoryId(categoryId);
    }
}
