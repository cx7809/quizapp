package com.example.quizapp.controller;

import com.example.quizapp.model.ContactUs;
import com.example.quizapp.service.ContactUsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contact-us")
public class ContactUsController {

    @Autowired
    private ContactUsService contactUsService;

    @GetMapping("/{id}")
    public ContactUs getContactUsById(@PathVariable Long id) {
        return contactUsService.findById(id);
    }

    @GetMapping
    public List<ContactUs> getAllMessages() {
        return contactUsService.findAll();
    }

    @PostMapping
    public void submitContactUs(@RequestBody ContactUs contactUs) {
        contactUsService.save(contactUs);
    }

    @DeleteMapping("/{id}")
    public void deleteContactUs(@PathVariable Long id) {
        ContactUs contactUs = contactUsService.findById(id);
        contactUsService.delete(contactUs);
    }
}
