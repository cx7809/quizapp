package com.example.quizapp.dao.impl;

import com.example.quizapp.dao.UserDAO;
import com.example.quizapp.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAOImpl implements UserDAO {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public User findByEmail(String email) {
        return (User) getCurrentSession()
                .createQuery("FROM User WHERE email = :email")
                .setParameter("email", email)
                .uniqueResult();
    }


    @Override
    public void save(User user) {
        getCurrentSession().saveOrUpdate(user);
    }
//
//    @Override
//    public void delete(User user) {
//        getCurrentSession().delete(user);
//    }
}
