package com.everis.bootcamp.employeeservice;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Employee {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String role;

    private Integer sueldo;

    public Employee() {
    }

    public Employee(String name, String role, Integer sueldo) {
        this.name = name;
        this.role = role;
        this.sueldo = sueldo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Integer getSueldo() {
        return sueldo;
    }

    public void setSueldo(Integer sueldo) {
        this.sueldo = sueldo;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", role='" + role + '\'' +
                ", sueldo=" + sueldo +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(id, employee.id) && Objects.equals(name, employee.name) && Objects.equals(role, employee.role) && Objects.equals(sueldo, employee.sueldo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, role, sueldo);
    }
}
