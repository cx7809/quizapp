package com.example.quizapp.controller;

import com.example.quizapp.model.Role;
import com.example.quizapp.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class AdminController {

    @GetMapping("/admin")
    public String adminHome(HttpSession session) {
        User user = (User) session.getAttribute("loggedInUser");
        if (user != null && Role.ADMIN.equals(user.getRole())) {
            return "adminHome"; // Render admin home page
        }
        return "redirect:/login"; // Redirect to login if not authorized
    }

}
