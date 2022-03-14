package com.hans.employeeservice.responses;

import com.hans.employeeservice.models.Department;
import com.hans.employeeservice.models.Employee;

public record EmployeeResponse(Long id, String email, String firstName, String lastName, Department department) {
}
