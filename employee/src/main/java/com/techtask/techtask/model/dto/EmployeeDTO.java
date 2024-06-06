package com.techtask.techtask.model.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class EmployeeDTO {
    private String firstName;
    private String lastName;
    private String department;
    private Double salary;

    public EmployeeDTO(String firstName, String lastName, String department, Double salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = department;
        this.salary = salary;
    }
}
