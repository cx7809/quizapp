package com.example.quizapp.dao.impl;

import com.example.quizapp.dao.CategoryDAO;
import com.example.quizapp.model.Category;
import com.example.quizapp.model.Question;
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
        String hql = "FROM Category";
        return getCurrentSession().createQuery(hql, Category.class).getResultList();
    }

    @Override
    public Category findBySlug(String slug) {
        String hql = "FROM Category c WHERE c.slug = :slug";
        return getCurrentSession().createQuery(hql, Category.class)
                .setParameter("slug", slug)
                .uniqueResult();
    }

}
