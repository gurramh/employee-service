package com.hans.employeeservice.services;

import com.hans.employeeservice.exceptions.NotFoundException;
import com.hans.employeeservice.models.Department;
import com.hans.employeeservice.models.Employee;
import com.hans.employeeservice.responses.EmployeeResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class EmployeeService {

    private RestTemplate restTemplate;
    private final String departmentBaseUrl;

    public EmployeeService(RestTemplate restTemplate, @Value("${department.api.base.url}") String departmentBaseUrl) {
        this.restTemplate = restTemplate;
        this.departmentBaseUrl = departmentBaseUrl;
    }

    private Map<Long, Employee> employeeDB = new HashMap<>(Map.of(1L, new Employee(1L, "ghk@hans.com", "Harish", "Gurram", 2L)));

    public EmployeeResponse getEmployee(Long id) {
        Employee employee = employeeDB.computeIfAbsent(id, key -> {
            throw new NotFoundException("Employee not found for id : " + id);
        });
        return new EmployeeResponse(employee.id(), employee.email(), employee.firstName(), employee.lastName(), getDepartmentById(employee.departmentId()));
    }

    private Department getDepartmentById(Long id) {
        return restTemplate.getForObject(departmentBaseUrl + "/{id}", Department.class, id);
    }
}
