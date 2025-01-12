package com.example.quizapp.dao;

import com.example.quizapp.model.User;
import java.util.List;

public interface UserDAO {
    User findById(Long id);
    List<User> findAll();
    User findByEmail(String email);
    void save(User user);
    void update(User user);
    void delete(User user);
}
