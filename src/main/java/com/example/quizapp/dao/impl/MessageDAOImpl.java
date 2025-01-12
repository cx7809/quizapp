package com.example.quizapp.dao.impl;

import com.example.quizapp.dao.MessageDAO;
import com.example.quizapp.model.Message;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MessageDAOImpl implements MessageDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void save(Message message) {
        Session session = sessionFactory.getCurrentSession();
        session.save(message);
    }
}
