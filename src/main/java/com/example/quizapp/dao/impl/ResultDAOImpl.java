package com.example.quizapp.dao.impl;

import com.example.quizapp.dao.ResultDAO;
import com.example.quizapp.model.Result;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ResultDAOImpl implements ResultDAO {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public void save(Result result) {
        getCurrentSession().save(result);
    }

    @Override
    public Result findById(Long id) {
        return getCurrentSession().get(Result.class, id);
    }
}
