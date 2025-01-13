package com.example.quizapp.controller;

import com.example.quizapp.model.Result;
import com.example.quizapp.service.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ResultController {

    @Autowired
    private ResultService resultService;

    @GetMapping("/result/{id}")
    public String viewResult(@PathVariable Long id, Model model) {
        Result result = resultService.getResultById(id);
        if (result == null) {
            return "error";
        }
        model.addAttribute("result", result);
        return "result";
    }
}
