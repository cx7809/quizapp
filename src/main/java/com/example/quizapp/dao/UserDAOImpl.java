package com.example.quizapp.dao;

import com.example.quizapp.model.User;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDAOImpl extends AbstractHibernateDAO<User> implements UserDAO {

    public UserDAOImpl() {
        setClazz(User.class);
    }

    @Override
    public User findByEmail(String email) {
        Session session = getCurrentSession();
        return session.createQuery("from User where email = :email", User.class)
                .setParameter("email", email)
                .uniqueResult();
    }
}
