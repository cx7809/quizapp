package com.example.quizapp.service.impl;

import com.example.quizapp.dao.MessageDAO;
import com.example.quizapp.model.Message;
import com.example.quizapp.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageDAO messageDAO;

    @Override
    @Transactional
    public void saveMessage(Message message) {
        messageDAO.save(message);
    }
}
