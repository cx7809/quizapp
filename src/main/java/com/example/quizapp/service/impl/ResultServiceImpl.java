package com.example.quizapp.service.impl;

import com.example.quizapp.dao.ResultDAO;
import com.example.quizapp.model.Result;
import com.example.quizapp.service.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ResultServiceImpl implements ResultService {

    @Autowired
    private ResultDAO resultDAO;

    @Override
    public void saveResult(Result result) {
        resultDAO.save(result);
    }

    @Override
    public Result getResultById(Long id) {
        return resultDAO.findById(id);
    }
}
