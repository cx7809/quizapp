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
    public List<Question> findRandomQuestionsByCategoryId(Long categoryId) {
        String hql = "FROM Question WHERE category.id = :categoryId ORDER BY RAND()";
        return getCurrentSession()
                .createQuery(hql, Question.class)
                .setParameter("categoryId", categoryId)
                .setMaxResults(5)
                .getResultList();
    }

    @Override
    public void save(Question question) {
        getCurrentSession().saveOrUpdate(question);
    }
}
