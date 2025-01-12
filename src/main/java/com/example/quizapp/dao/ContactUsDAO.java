package com.example.quizapp.dao;

import com.example.quizapp.model.ContactUs;

import java.util.List;

public interface ContactUsDAO {
    ContactUs findById(Long id);

    List<ContactUs> findAll();

    void save(ContactUs contactUs);

    void delete(ContactUs contactUs);
}
