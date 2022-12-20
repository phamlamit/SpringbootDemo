package com.example.controller;

import com.example.model.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("person")
public class PersonController {
    @GetMapping("/get")
    public String person(Model model) {
        Person p1 = new Person();
        p1.setId(1);
        p1.setName("Lam");

        model.addAttribute("person", p1);
        return "person";
    }

    @GetMapping("/list")
    public String personList(){
        return "person-list";
    }
}
