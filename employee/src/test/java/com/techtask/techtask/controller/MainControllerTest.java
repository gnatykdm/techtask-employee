package com.techtask.techtask.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.techtask.techtask.model.entity.EmployeeEntity;
import com.techtask.techtask.model.service.IEmployeeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class MainControllerTest {

    @MockBean
    private IEmployeeService employeeService;

    @Autowired
    private MockMvc mockMvc;

    private EmployeeEntity employeeEntity;

    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    public void setUp() {
        employeeEntity = new EmployeeEntity("John", "Doe", "IT", 1000.0);
    }

    @Test
    void getAllEmployee() throws Exception {
        mockMvc.perform(get("/api/v1/employee/all")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void getEmployee() throws Exception {
        EmployeeEntity employee = new EmployeeEntity("Jan", "Dae", "HR", 2000.0);
        employeeService.saveEmployee(employee);

        mockMvc.perform(get("/api/v1/employee/get/" + employee.getId())
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void registerEmployee() throws Exception {
        EmployeeEntity emp = new EmployeeEntity("Jane", "Doe", "HR", 2000.0);

        mockMvc.perform(post("/api/v1/employee/register")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(emp))
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void deleteEmployee() throws Exception {
        EmployeeEntity emp = new EmployeeEntity("Jane", "Doe", "HR", 2000.0);
        employeeService.saveEmployee(emp);


        mockMvc.perform(delete("/api/v1/employee/delete/" + employeeEntity.getId())
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}
