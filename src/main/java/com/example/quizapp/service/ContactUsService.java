package com.example.quizapp.service;

import com.example.quizapp.model.ContactUs;

import java.util.List;

public interface ContactUsService {
    ContactUs findById(Long id);

    List<ContactUs> findAll();

    void save(ContactUs contactUs);

    void delete(ContactUs contactUs);
}
