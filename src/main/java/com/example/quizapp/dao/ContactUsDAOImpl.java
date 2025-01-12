package com.example.quizapp.dao;

import com.example.quizapp.model.ContactUs;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public class ContactUsDAOImpl extends AbstractHibernateDAO<ContactUs> implements ContactUsDAO {

    public ContactUsDAOImpl() {
        setClazz(ContactUs.class); // Set the entity class
    }
}
