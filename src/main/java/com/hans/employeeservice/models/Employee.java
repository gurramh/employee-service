package com.hans.employeeservice.models;

public record Employee(Long id, String email, String firstName, String lastName, Long departmentId) {
}
