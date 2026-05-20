package com.caraveolobotech.employeeservice.service.impl;

import com.caraveolobotech.employeeservice.dto.EmployeeRequestDTO;
import com.caraveolobotech.employeeservice.dto.EmployeeResponseDTO;
import com.caraveolobotech.employeeservice.entity.Employee;
import com.caraveolobotech.employeeservice.exception.ResourceNotFoundException;
import com.caraveolobotech.employeeservice.repository.EmployeeRepository;
import com.caraveolobotech.employeeservice.service.EmployeeService;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(
            EmployeeRepository employeeRepository
    ) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public EmployeeResponseDTO createEmployee(
            EmployeeRequestDTO request
    ) {

        Employee employee = mapToEntity(request);

        Employee savedEmployee =
                employeeRepository.save(employee);

        return mapToResponse(savedEmployee);
    }

    @Override
    public List<EmployeeResponseDTO> createEmployees(
            List<EmployeeRequestDTO> requests
    ) {

        List<Employee> employees = requests.stream()
                .map(this::mapToEntity)
                .toList();

        List<Employee> savedEmployees =
                employeeRepository.saveAll(employees);

        return savedEmployees.stream()
                .map(this::mapToResponse)
                .toList();
    }

    @Override
    public List<EmployeeResponseDTO> getAllEmployees() {

        return employeeRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    @Override
    public EmployeeResponseDTO getEmployeeById(Long id) {

        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Employee not found with id: " + id
                        )
                );

        return mapToResponse(employee);
    }

    @Override
    public EmployeeResponseDTO updateEmployee(
            Long id,
            EmployeeRequestDTO request
    ) {

        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Employee not found with id: " + id
                        )
                );

        employee.setFirstName(request.getFirstName());
        employee.setSecondName(request.getSecondName());
        employee.setPaternalLastName(
                request.getPaternalLastName()
        );
        employee.setMaternalLastName(
                request.getMaternalLastName()
        );
        employee.setEmail(request.getEmail());
        employee.setAge(request.getAge());
        employee.setGender(request.getGender());
        employee.setBirthDate(request.getBirthDate());
        employee.setPosition(request.getPosition());
        employee.setActive(request.getActive());

        Employee updatedEmployee =
                employeeRepository.save(employee);

        return mapToResponse(updatedEmployee);
    }

    @Override
    public List<EmployeeResponseDTO> searchEmployeesByName(
            String name
    ) {

        return employeeRepository
                .findByFirstNameContainingIgnoreCase(name)
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    @Override
    public void deleteEmployee(Long id) {

        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Employee not found with id: " + id
                        )
                );

        employeeRepository.delete(employee);
    }

    private Employee mapToEntity(
            EmployeeRequestDTO request
    ) {

        Employee employee = new Employee();

        employee.setFirstName(request.getFirstName());
        employee.setSecondName(request.getSecondName());
        employee.setPaternalLastName(
                request.getPaternalLastName()
        );
        employee.setMaternalLastName(
                request.getMaternalLastName()
        );
        employee.setEmail(request.getEmail());
        employee.setAge(request.getAge());
        employee.setGender(request.getGender());
        employee.setBirthDate(request.getBirthDate());
        employee.setPosition(request.getPosition());
        employee.setActive(request.getActive());

        return employee;
    }

    private EmployeeResponseDTO mapToResponse(
            Employee employee
    ) {

        return new EmployeeResponseDTO(
                employee.getId(),
                employee.getFirstName(),
                employee.getSecondName(),
                employee.getPaternalLastName(),
                employee.getMaternalLastName(),
                employee.getEmail(),
                employee.getAge(),
                employee.getGender(),
                employee.getBirthDate(),
                employee.getPosition(),
                employee.getActive(),
                employee.getCreatedAt()
        );
    }
}