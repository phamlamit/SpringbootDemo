package com.example.controller;

import com.example.model.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PersonController {
    @GetMapping("/person")
    public String getPerson(Model model) {
        Person person = new Person(1, "Lam");
        model.addAttribute("p", person);
        return "person";
    }
}
