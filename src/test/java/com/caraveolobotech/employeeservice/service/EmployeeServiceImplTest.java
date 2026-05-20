package com.caraveolobotech.employeeservice.service;

import com.caraveolobotech.employeeservice.dto.EmployeeRequestDTO;
import com.caraveolobotech.employeeservice.dto.EmployeeResponseDTO;
import com.caraveolobotech.employeeservice.entity.Employee;
import com.caraveolobotech.employeeservice.exception.ResourceNotFoundException;
import com.caraveolobotech.employeeservice.repository.EmployeeRepository;
import com.caraveolobotech.employeeservice.service.impl.EmployeeServiceImpl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.*;

public class EmployeeServiceImplTest {

    @Mock
    private EmployeeRepository employeeRepository;

    @InjectMocks
    private EmployeeServiceImpl employeeService;

    private Employee employee;

    private EmployeeRequestDTO requestDTO;

    @BeforeEach
    void setUp() {

        MockitoAnnotations.openMocks(this);

        employee = new Employee();

        employee.setId(1L);
        employee.setFirstName("Carlos");
        employee.setSecondName("Alberto");
        employee.setPaternalLastName("Caraveo");
        employee.setMaternalLastName("Lopez");
        employee.setEmail("carlos@test.com");
        employee.setAge(30);
        employee.setGender("MALE");
        employee.setBirthDate(
                LocalDate.of(1995, 5, 10)
        );
        employee.setPosition("Backend Developer");
        employee.setActive(true);

        requestDTO = new EmployeeRequestDTO();

        requestDTO.setFirstName("Carlos");
        requestDTO.setSecondName("Alberto");
        requestDTO.setPaternalLastName("Caraveo");
        requestDTO.setMaternalLastName("Lopez");
        requestDTO.setEmail("carlos@test.com");
        requestDTO.setAge(30);
        requestDTO.setGender("MALE");
        requestDTO.setBirthDate(
                LocalDate.of(1995, 5, 10)
        );
        requestDTO.setPosition("Backend Developer");
        requestDTO.setActive(true);
    }

    @Test
    void shouldCreateEmployee() {

        when(employeeRepository.save(any(Employee.class)))
                .thenReturn(employee);

        EmployeeResponseDTO response =
                employeeService.createEmployee(requestDTO);

        assertNotNull(response);

        assertEquals(
                "Carlos",
                response.getFirstName()
        );

        verify(employeeRepository, times(1))
                .save(any(Employee.class));
    }

    @Test
    void shouldGetEmployeeById() {

        when(employeeRepository.findById(1L))
                .thenReturn(Optional.of(employee));

        EmployeeResponseDTO response =
                employeeService.getEmployeeById(1L);

        assertNotNull(response);

        assertEquals(
                "Carlos",
                response.getFirstName()
        );
    }

    @Test
    void shouldThrowExceptionWhenEmployeeNotFound() {

        when(employeeRepository.findById(1L))
                .thenReturn(Optional.empty());

        assertThrows(
                ResourceNotFoundException.class,
                () -> employeeService.getEmployeeById(1L)
        );
    }

    @Test
    void shouldGetAllEmployees() {

        when(employeeRepository.findAll())
                .thenReturn(List.of(employee));

        List<EmployeeResponseDTO> employees =
                employeeService.getAllEmployees();

        assertEquals(1, employees.size());
    }

    @Test
    void shouldDeleteEmployee() {

        when(employeeRepository.findById(1L))
                .thenReturn(Optional.of(employee));

        doNothing()
                .when(employeeRepository)
                .delete(employee);

        employeeService.deleteEmployee(1L);

        verify(employeeRepository, times(1))
                .delete(employee);
    }

    @Test
    void shouldSearchEmployeesByName() {

        when(employeeRepository
                .findByFirstNameContainingIgnoreCase("car"))
                .thenReturn(List.of(employee));

        List<EmployeeResponseDTO> result =
                employeeService.searchEmployeesByName("car");

        assertEquals(1, result.size());

        assertEquals(
                "Carlos",
                result.get(0).getFirstName()
        );
    }
}