package com.caraveolobotech.employeeservice.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class EmployeeResponseDTO {

    private Long id;

    private String firstName;

    private String secondName;

    private String paternalLastName;

    private String maternalLastName;

    private String email;

    private Integer age;

    private String gender;

    private LocalDate birthDate;

    private String position;

    private Boolean active;

    private LocalDateTime createdAt;

    public EmployeeResponseDTO() {
    }

    public EmployeeResponseDTO(
            Long id,
            String firstName,
            String secondName,
            String paternalLastName,
            String maternalLastName,
            String email,
            Integer age,
            String gender,
            LocalDate birthDate,
            String position,
            Boolean active,
            LocalDateTime createdAt
    ) {
        this.id = id;
        this.firstName = firstName;
        this.secondName = secondName;
        this.paternalLastName = paternalLastName;
        this.maternalLastName = maternalLastName;
        this.email = email;
        this.age = age;
        this.gender = gender;
        this.birthDate = birthDate;
        this.position = position;
        this.active = active;
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public String getPaternalLastName() {
        return paternalLastName;
    }

    public String getMaternalLastName() {
        return maternalLastName;
    }

    public String getEmail() {
        return email;
    }

    public Integer getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public String getPosition() {
        return position;
    }

    public Boolean getActive() {
        return active;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}