package com.example.quizapp.dao.impl;

import com.example.quizapp.dao.QuestionDAO;
import com.example.quizapp.model.Question;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class QuestionDAOImpl implements QuestionDAO {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }


    @Override
    public void save(Question question) {
        getCurrentSession().saveOrUpdate(question);
    }

    @Override
    public List<Question> getRandomQuestionsByCategory(String categorySlug, int limit) {
        String hql = "FROM Question q WHERE q.category.slug = :categorySlug ORDER BY RAND()";
        List<Question> questions = getCurrentSession()
                .createQuery(hql, Question.class)
                .setParameter("categorySlug", categorySlug)
                .setMaxResults(limit)
                .getResultList();

        return questions;
    }
}
