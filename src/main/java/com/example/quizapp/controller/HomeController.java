package com.example.quizapp.controller;

import com.example.quizapp.model.Category;
import com.example.quizapp.model.Role;
import com.example.quizapp.model.User;
import com.example.quizapp.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/home")
    public String home(HttpSession session, Model model) {
        User user = (User) session.getAttribute("loggedInUser");
//        System.out.println("User from session: " + user); // Testing
//        System.out.println("User role: " + user.getRole()); // Testing

        if (user != null) {
            if (Role.USER.equals(user.getRole())) {
                // Load categories for the user home
                List<Category> categories = categoryService.getAllCategories();
                model.addAttribute("categories", categories);
                return "home"; // User home view
            } else if (Role.ADMIN.equals(user.getRole())) {
                System.out.println("Accessing admin home"); // Testing
                return "redirect:/admin"; // Redirect admin to admin home
            }
        }

        // If user is not logged in or role is invalid
        return "redirect:/login";
    }


}
