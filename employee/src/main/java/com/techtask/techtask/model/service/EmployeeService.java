package com.techtask.techtask.model.service;

import com.techtask.techtask.model.entity.EmployeeEntity;
import com.techtask.techtask.model.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Service
public class EmployeeService implements IEmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    private static final Logger LOGGER = Logger.getLogger(EmployeeService.class.getName());

    @Override
    public void registerEmployee(String firstName, String lastName, String department, Double salary) {
        if (firstName == null || lastName == null || department == null || salary == null) {
            throw new IllegalArgumentException("All fields are required");
        }

        LOGGER.info("Registering employee");
        EmployeeEntity employee = new EmployeeEntity(firstName, lastName, department, salary);
        employeeRepository.save(employee);
    }

    @Override
    public void saveEmployee(EmployeeEntity employee) {
        if (employee == null) {
            throw new IllegalArgumentException("Employee is required");
        }

        LOGGER.info("Saving employee");
        employeeRepository.save(employee);
    }

    @Override
    public void deleteEmployee(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("Id is required");
        }

        LOGGER.info("Deleting employee");
        employeeRepository.deleteById(id);
    }

    @Override
    public EmployeeEntity getEmployee(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("Id is required");
        }

        LOGGER.info("Getting employee");
        Optional<EmployeeEntity> employee = employeeRepository.findById(id);
        if (employee.isPresent()) {
            return employee.get();
        }
        return null;
    }

    @Override
    public List<EmployeeEntity> getAllEmployees() {
        LOGGER.info("Getting all employees");
        return employeeRepository.findAll();
    }
}
