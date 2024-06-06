package com.techtask.techtask.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table(name = "employee")
public class EmployeeEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name", unique = true, nullable = false)
    @Size(min = 4, message = "Name should have at least 4 characters")
    private String firstName;

    @Column(name = "last_name", unique = true, nullable = false)
    @Size(min = 4, message = "Name should have at least 4 characters")
    private String lastName;

    @Column(name = "department")
    @Size(min = 5, message = "Email should have at least 5 characters")
    private String department;

    @Column(name = "salary")
    private Double salary;

    public EmployeeEntity(String firstName, String lastName, String department, Double salary) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = department;
        this.salary = salary;
    }
}
