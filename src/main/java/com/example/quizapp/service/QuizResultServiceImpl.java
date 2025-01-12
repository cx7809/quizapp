package com.example.quizapp.service;

import com.example.quizapp.dao.QuizResultDAO;
import com.example.quizapp.model.QuizResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class QuizResultServiceImpl implements QuizResultService {

    @Autowired
    private QuizResultDAO quizResultDAO;

    @Override
    public QuizResult findById(Long id) {
        return quizResultDAO.findById(id);
    }

    @Override
    public List<QuizResult> findAll() {
        return quizResultDAO.findAll();
    }

    @Override
    public void save(QuizResult quizResult) {
        quizResultDAO.save(quizResult);
    }

    @Override
    public void update(QuizResult quizResult) {
        quizResultDAO.update(quizResult);
    }

    @Override
    public void delete(QuizResult quizResult) {
        quizResultDAO.delete(quizResult);
    }

    @Override
    public List<QuizResult> findByUserId(Long userId) {
        return quizResultDAO.findByUserId(userId);
    }
}
