package com.javaproject.employeespringbootbackend.controller;

import com.javaproject.employeespringbootbackend.model.Employee;
import com.javaproject.employeespringbootbackend.repository.EmployeeRepository;
import org.apache.coyote.Response;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/employess")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping
    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }

    // create employee rest api
    @PostMapping
    public Employee createEmployee (@RequestBody Employee employee){
        return employeeRepository.save(employee);
    }
    //build get employee by id Rest API
    @GetMapping("{id}")
    public ResponseEntity<Employee> getEmployeebyId(@PathVariable long id){
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id" + id));
        return ResponseEntity.ok(employee);
    }

    //build update employee REST API
    @PutMapping("{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable long id , @RequestBody  Employee employeeDetails){
        Employee updateEmployee = employeeRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Employee not exist with id" +id));
        updateEmployee.setFirstName(employeeDetails.getFirstName());
        updateEmployee.setLastName(employeeDetails.getLastName());
        updateEmployee.setEmailId(employeeDetails.getEmailId());

        employeeRepository.save(updateEmployee);

        return ResponseEntity.ok(updateEmployee);
    }

    //build delete employee
    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteEmployee( @PathVariable long id){
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Employee not exist with id" +id));
        employeeRepository.delete(employee);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
