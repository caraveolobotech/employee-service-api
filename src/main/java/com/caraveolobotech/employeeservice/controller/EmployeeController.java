package com.caraveolobotech.employeeservice.controller;

import com.caraveolobotech.employeeservice.dto.EmployeeRequestDTO;
import com.caraveolobotech.employeeservice.dto.EmployeeResponseDTO;
import com.caraveolobotech.employeeservice.service.EmployeeService;

import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(
            EmployeeService employeeService
    ) {
        this.employeeService = employeeService;
    }

    @PostMapping
    public ResponseEntity<EmployeeResponseDTO> createEmployee(
            @Valid @RequestBody EmployeeRequestDTO request
    ) {

        EmployeeResponseDTO response =
                employeeService.createEmployee(request);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }

    @PostMapping("/bulk")
    public ResponseEntity<List<EmployeeResponseDTO>>
    createEmployees(
            @Valid
            @RequestBody
            List<EmployeeRequestDTO> requests
    ) {

        List<EmployeeResponseDTO> response =
                employeeService.createEmployees(requests);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }

    @GetMapping
    public ResponseEntity<List<EmployeeResponseDTO>>
    getAllEmployees() {

        return ResponseEntity.ok(
                employeeService.getAllEmployees()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeResponseDTO>
    getEmployeeById(
            @PathVariable Long id
    ) {

        return ResponseEntity.ok(
                employeeService.getEmployeeById(id)
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmployeeResponseDTO>
    updateEmployee(
            @PathVariable Long id,
            @Valid @RequestBody EmployeeRequestDTO request
    ) {

        return ResponseEntity.ok(
                employeeService.updateEmployee(id, request)
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(
            @PathVariable Long id
    ) {

        employeeService.deleteEmployee(id);

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/search")
    public ResponseEntity<List<EmployeeResponseDTO>>
    searchEmployees(
            @RequestParam String name
    ) {

        return ResponseEntity.ok(
                employeeService.searchEmployeesByName(name)
        );
    }
}