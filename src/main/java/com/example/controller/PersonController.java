package com.example.controller;

import com.example.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PersonController {

    @Autowired
    private EmployeeService service;

    @GetMapping("/person")
    public String getPerson(Model model) {
        model.addAttribute("p", service.fillAllEmployee());
        return "person";
    }
}
