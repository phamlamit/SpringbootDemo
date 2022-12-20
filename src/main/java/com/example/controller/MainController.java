package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @Value("${my.key}")
    private String hello;

    @Autowired
    private Environment evn;

    @GetMapping("/")
    public String home(Model model) {
        System.out.println(hello);
        System.out.println(evn.getProperty("my.key"));

        String s = "Hello Day La Lam";
        model.addAttribute("msg", s);
        return "index";
    }
}
