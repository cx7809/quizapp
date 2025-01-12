package com.example.quizapp.service;

import com.example.quizapp.dao.ContactUsDAO;
import com.example.quizapp.model.ContactUs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ContactUsServiceImpl implements ContactUsService {

    @Autowired
    private ContactUsDAO contactUsDAO;

    @Override
    public ContactUs findById(Long id) {
        return contactUsDAO.findById(id);
    }

    @Override
    public List<ContactUs> findAll() {
        return contactUsDAO.findAll();
    }

    @Override
    public void save(ContactUs contactUs) {
        contactUsDAO.save(contactUs);
    }

    @Override
    public void delete(ContactUs contactUs) {
        contactUsDAO.delete(contactUs);
    }
}
