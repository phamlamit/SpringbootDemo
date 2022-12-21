package com.example.controller;

import com.example.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class MainController {
    public static List<Employee> employees = new ArrayList<>();

    @Autowired
    MessageSource messageSource;

    @GetMapping("/")
    public String home(Model model) {
        Integer x = null;
        x +=10;
        employees.addAll(Arrays.asList(new Employee(1, "A", 50),
                new Employee(2, "B", 23), new Employee(4, "D", 45),
                new Employee(3, "C", 34), new Employee(5, "E", 21)));
        model.addAttribute("msg", messageSource.getMessage("my.name", null, null));
        return "index";
    }

    @GetMapping("/employees")
    public String employees(Model model) {
        model.addAttribute("employees", employees);
        model.addAttribute("employee", new Employee(1, "lam", 24));
        return "employees";
    }

    @PostMapping("/employee")
    public String addEmployee(Model model, @ModelAttribute(name = "employee") Employee employee) {
        employee.setId(employees.size());
        employees.add(employee);
        return "redirect:/employees";
    }

    @GetMapping("/download-file")
    public void download(HttpServletRequest request, HttpServletResponse response) {
        String dataDirectory = ("/img/");
        Path file = Paths.get(dataDirectory, "hello.jpg");
        if (Files.exists(file)) {
            response.setContentType("image/jpg");
            response.addHeader("Content-Disposition", "attachment;filename=anh.jpg");
            try {
                Files.copy(file, response.getOutputStream());
                response.getOutputStream().flush();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
