package com.example.quizapp.service;

import com.example.quizapp.model.Result;

public interface ResultService {
    void saveResult(Result result);
    Result getResultById(Long id);
}
