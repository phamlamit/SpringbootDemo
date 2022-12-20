package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @Autowired
    MessageSource messageSource;

    @GetMapping("/")
    public String home(Model model) {

        model.addAttribute("msg", messageSource.getMessage("my.name", null, null));
        return "index";
    }
}
