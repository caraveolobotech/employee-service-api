package com.caraveolobotech.employeeservice.service;

import com.caraveolobotech.employeeservice.dto.EmployeeRequestDTO;
import com.caraveolobotech.employeeservice.dto.EmployeeResponseDTO;

import java.util.List;

public interface EmployeeService {

    EmployeeResponseDTO createEmployee(EmployeeRequestDTO request);

    List<EmployeeResponseDTO> createEmployees(
            List<EmployeeRequestDTO> requests
    );

    List<EmployeeResponseDTO> getAllEmployees();

    EmployeeResponseDTO getEmployeeById(Long id);

    EmployeeResponseDTO updateEmployee(
            Long id,
            EmployeeRequestDTO request
    );

    List<EmployeeResponseDTO> searchEmployeesByName(
            String name
    );

    void deleteEmployee(Long id);
}