package com.example.quizapp.dao;

import com.example.quizapp.model.Result;

public interface ResultDAO {
    void save(Result result); // 保存一个结果
    Result findById(Long id); // 通过ID查找结果
}
