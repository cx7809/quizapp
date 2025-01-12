package com.example.quizapp.service.impl;

import com.example.quizapp.dao.UserDAO;
import com.example.quizapp.model.Status;
import com.example.quizapp.model.User;
import com.example.quizapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Override
    public User findByEmail(String email) {
        User user = userDAO.findByEmail(email);
        if (user != null && Status.SUSPENDED.equals(user.getStatus())) {
            throw new RuntimeException("This account is suspended. Please contact support.");
        }
        return user;
    }

    @Override
    public void save(User user) {
        User existingUser = userDAO.findByEmail(user.getEmail());
        if (existingUser != null) {
            if (Status.SUSPENDED.equals(existingUser.getStatus())) {
                throw new RuntimeException("This email is associated with a suspended account. Please contact support.");
            } else {
                throw new RuntimeException("Email already registered!");
            }
        }
        userDAO.save(user);
    }
}
