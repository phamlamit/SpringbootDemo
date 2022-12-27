package com.example.service.impl;

import com.example.entity.Employee;
import com.example.model.EmployeeDTO;
import com.example.repository.EmployeeRepository;
import com.example.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository repository;

    @Override
    public List<EmployeeDTO> fillAllEmployee() {
        List<Employee> employees = repository.getAllEmployee();
        return null;
    }
}
