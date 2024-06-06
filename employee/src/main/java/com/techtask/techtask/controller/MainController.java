package com.techtask.techtask.controller;

import com.techtask.techtask.model.dto.EmployeeDTO;
import com.techtask.techtask.model.entity.EmployeeEntity;
import com.techtask.techtask.model.service.IEmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/employee")
public class MainController {

    @Autowired
    private IEmployeeService employeeService;

    private Logger logger = LoggerFactory.getLogger(MainController.class);

    @GetMapping("/all")
    public ResponseEntity<List<EmployeeEntity>> getAllEmployee() {
        logger.info("Getting all employees");
        return ResponseEntity.ok(employeeService.getAllEmployees());
    }

    @GetMapping("/get/{userId}")
    public ResponseEntity<EmployeeEntity> getEmployee(@PathVariable Integer userId) {
        logger.info("Getting employee with id: " + userId);
        return ResponseEntity.ok(employeeService.getEmployee(Long.valueOf(userId)));
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerEmployee(@RequestBody EmployeeDTO employeeDTO) {
        EmployeeEntity employeeEntity = new EmployeeEntity(employeeDTO.getFirstName(), employeeDTO.getLastName(), employeeDTO.getDepartment(), employeeDTO.getSalary());
        employeeService.registerEmployee(employeeEntity.getFirstName(), employeeEntity.getLastName(), employeeEntity.getDepartment(), employeeEntity.getSalary());

        logger.info("Employee registered successfully");
        return ResponseEntity.ok("Employee registered successfully");
    }

    @DeleteMapping("/delete/{userId}")
    public ResponseEntity<?> deleteEmployee(@PathVariable Long userId) {

        logger.info("Deleting employee with id: " + userId);
        employeeService.deleteEmployee(userId);
        return ResponseEntity.ok("Employee deleted successfully");
    }
}
