package com.caraveolobotech.employeeservice.repository;

import com.caraveolobotech.employeeservice.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository
        extends JpaRepository<Employee, Long> {

    List<Employee> findByFirstNameContainingIgnoreCase(
            String firstName
    );
}