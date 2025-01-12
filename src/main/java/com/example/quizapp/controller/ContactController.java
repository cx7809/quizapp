package com.example.quizapp.controller;

import com.example.quizapp.model.Message;
import com.example.quizapp.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ContactController {

    @Autowired
    private MessageService messageService;

    @GetMapping("/contact")
    public String showContactForm(Model model) {
        model.addAttribute("message", new Message());
        return "contact";
    }

    @PostMapping("/contact")
    public String handleContactForm(Message message, Model model) {
        messageService.saveMessage(message);
        model.addAttribute("successMessage", "Your message has been sent successfully!");
        return "contact";
    }
}
