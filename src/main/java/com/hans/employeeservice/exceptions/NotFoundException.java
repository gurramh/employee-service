package com.hans.employeeservice.exceptions;

public class NotFoundException extends EmployeeServiceException {

    public NotFoundException(String message) {
        super(message);
    }
}
