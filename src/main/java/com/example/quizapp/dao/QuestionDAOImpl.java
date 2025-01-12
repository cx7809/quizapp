package com.example.quizapp.dao;

import com.example.quizapp.model.Question;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class QuestionDAOImpl extends AbstractHibernateDAO<Question> implements QuestionDAO {

    public QuestionDAOImpl() {
        setClazz(Question.class); // Set the entity class
    }

    @Override
    public List<Question> findByCategoryId(Long categoryId) {
        Session session = getCurrentSession();
        return session.createQuery("from Question where category.id = :categoryId", Question.class)
                .setParameter("categoryId", categoryId)
                .list();
    }
}
