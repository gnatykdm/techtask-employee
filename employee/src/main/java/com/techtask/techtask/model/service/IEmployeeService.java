package com.techtask.techtask.model.service;

import com.techtask.techtask.model.entity.EmployeeEntity;

import java.util.List;

public interface IEmployeeService {
    void registerEmployee(String firstName, String lastName, String department, Double salary);

    void saveEmployee(EmployeeEntity employee);

    void deleteEmployee(Long id);

    EmployeeEntity getEmployee(Long id);

    List<EmployeeEntity> getAllEmployees();
}
