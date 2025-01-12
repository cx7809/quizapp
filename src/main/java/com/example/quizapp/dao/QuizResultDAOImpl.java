package com.example.quizapp.dao;

import com.example.quizapp.model.QuizResult;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class QuizResultDAOImpl extends AbstractHibernateDAO<QuizResult> implements QuizResultDAO {

    public QuizResultDAOImpl() {
        setClazz(QuizResult.class); // Set the entity class
    }

    @Override
    public List<QuizResult> findByUserId(Long userId) {
        Session session = getCurrentSession();
        return session.createQuery("from QuizResult where user.id = :userId", QuizResult.class)
                .setParameter("userId", userId)
                .list();
    }
}
