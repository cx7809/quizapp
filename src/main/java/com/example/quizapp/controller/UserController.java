package com.example.quizapp.controller;

import com.example.quizapp.model.Role;
import com.example.quizapp.model.Status;
import com.example.quizapp.model.User;
import com.example.quizapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/register")
    public String showRegistrationPage(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
    public String handleRegister(@RequestParam String firstName,
                                 @RequestParam String lastName,
                                 @RequestParam String email,
                                 @RequestParam String password,
                                 Model model) {
        try {
            User newUser = new User();
            newUser.setFirstName(firstName);
            newUser.setLastName(lastName);
            newUser.setEmail(email);
            newUser.setPassword(password);
            newUser.setRole(Role.USER);// Default role
            newUser.setStatus(Status.ACTIVE);  // Default status
            userService.save(newUser);
            model.addAttribute("message", "Registration successful! Please log in.");
            return "login"; // Redirect to login after successful registration
        } catch (RuntimeException e) {
            model.addAttribute("error", e.getMessage());
            return "register";
        }
    }


    @GetMapping("/login")
    public String showLoginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String handleLogin(@RequestParam String email,
                              @RequestParam String password,
                              HttpSession session,
                              Model model) {
        try {
            User user = userService.findByEmail(email);
            if (user == null) {
                model.addAttribute("error", "User not found!");
                return "login";
            }
            if (!user.getPassword().equals(password)) {
                model.addAttribute("error", "Invalid credentials!");
                return "login";
            }
            if ("SUSPENDED".equals(user.getStatus())) {
                model.addAttribute("error", "Your account is suspended. Please contact support.");
                return "login";
            }

            session.setAttribute("loggedInUser", user);
            session.setAttribute("role", user.getRole());
//            System.out.println("User Role: " + user.getRole()); // Testing

            if (Role.ADMIN.equals(user.getRole())) {
                return "redirect:/admin";
            } else {
                return "redirect:/home";
            }
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "login";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }

}
