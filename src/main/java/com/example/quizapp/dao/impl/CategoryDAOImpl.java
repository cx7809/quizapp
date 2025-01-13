package com.example.quizapp.dao.impl;

import com.example.quizapp.dao.CategoryDAO;
import com.example.quizapp.model.Category;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CategoryDAOImpl implements CategoryDAO {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public List<Category> findAll() {
        return getCurrentSession().createQuery("FROM Category", Category.class).getResultList();
    }

    @Override
    public Category findBySlug(String slug) {
        return (Category) getCurrentSession()
                .createQuery("FROM Category WHERE slug = :slug")
                .setParameter("slug", slug)
                .uniqueResult();
    }

}
