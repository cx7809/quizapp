package com.example.quizapp.dao;

import com.example.quizapp.model.Category;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class CategoryDAOImpl extends AbstractHibernateDAO<Category> implements CategoryDAO {

    public CategoryDAOImpl() {
        setClazz(Category.class); // Set the entity class
    }

    @Override
    public Category findByName(String name) {
        Session session = getCurrentSession();
        return session.createQuery("from Category where name = :name", Category.class)
                .setParameter("name", name)
                .uniqueResult();
    }
}
