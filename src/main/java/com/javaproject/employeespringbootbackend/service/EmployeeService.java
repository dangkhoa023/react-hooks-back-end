package com.javaproject.employeespringbootbackend.service;

import com.javaproject.employeespringbootbackend.dto.EmployeeDTO;
import com.javaproject.employeespringbootbackend.model.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    List<Employee> findAllEmployee();
    Optional<Employee> findById(Long id);
    EmployeeDTO saveEmployee(EmployeeDTO employeeDTO);
    EmployeeDTO updateEmployee(EmployeeDTO employeeDTO);
    void deleteEmployee(Long id);

}
