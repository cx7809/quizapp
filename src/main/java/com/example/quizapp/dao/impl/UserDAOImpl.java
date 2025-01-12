package com.example.quizapp.dao.impl;

import com.example.quizapp.dao.UserDAO;
import com.example.quizapp.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class UserDAOImpl implements UserDAO {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public User findById(Long id) {
        return getCurrentSession().get(User.class, id);
    }

    @Override
    public List<User> findAll() {
        return getCurrentSession().createQuery("from User", User.class).list();
    }

    @Override
    public User findByEmail(String email) {
        return getCurrentSession()
                .createQuery("from User where email = :email", User.class)
                .setParameter("email", email)
                .uniqueResult();
    }

    @Override
    public void save(User user) {
        getCurrentSession().save(user);
    }

    @Override
    public void update(User user) {
        getCurrentSession().merge(user);
    }

    @Override
    public void delete(User user) {
        getCurrentSession().delete(user);
    }
}
