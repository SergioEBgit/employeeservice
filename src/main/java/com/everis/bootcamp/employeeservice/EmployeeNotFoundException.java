package com.everis.bootcamp.employeeservice;

public class EmployeeNotFoundException extends RuntimeException{
    public EmployeeNotFoundException(Long id) {
        super("Empleado no encontrado: " + id);
    }
}
