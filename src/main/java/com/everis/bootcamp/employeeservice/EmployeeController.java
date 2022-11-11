package com.everis.bootcamp.employeeservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class EmployeeController {

    @Autowired
    Environment environment;
    private final EmployeeRepository repository;

    public EmployeeController(EmployeeRepository repository){
        this.repository = repository;
    }

    @GetMapping("/employees")
    public List<Employee> findAll(){
        return this.repository.findAll().stream().map(e->{
            e.setName(e.getName() + ":" + environment.getProperty("local.server.port"));
            return e;
        }).collect(Collectors.toList());
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee newEmployee){
        return this.repository.save(newEmployee);
    }

    @GetMapping("/employees/{id}")
    public Employee getEmployee(@PathVariable Long id){
        Employee employee = new Employee("","",0);
        try {
            employee = this.repository.findById(id).orElseThrow(()->new EmployeeNotFoundException(id));
        }catch (EmployeeNotFoundException e){
        }finally{
            return employee;
        }
    }

    @PutMapping("/employees/{id}")
    public Employee createOrUpdateEmployee(@RequestBody Employee employee, @PathVariable Long id){
        return this.repository.findById(id).map((e)->{
            e.setName(employee.getName());
            e.setSueldo(employee.getSueldo());
            e.setRole(employee.getRole());
            return this.repository.save(e);
        }).orElseGet(()->{
            employee.setId(id);
            return this.repository.save(employee);
        });
    }

    @DeleteMapping("/employees/{id}")
    public void deleteEmployee(@PathVariable Long id){
        this.repository.deleteById(id);
    }
}
