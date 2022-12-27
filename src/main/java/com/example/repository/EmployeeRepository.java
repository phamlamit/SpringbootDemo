package com.example.repository;

import com.example.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    @Query("select e FROM Employee e ")
    List<Employee> getAllEmployee();

    Optional<Employee> findById(int id);
}
