package com.javaproject.employeespringbootbackend.service.impl;

import com.javaproject.employeespringbootbackend.dto.EmployeeDTO;
import com.javaproject.employeespringbootbackend.model.Employee;
import com.javaproject.employeespringbootbackend.repository.EmployeeRepository;
import com.javaproject.employeespringbootbackend.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> findAllEmployee() {
        return employeeRepository.findAll();
    }

    @Override
    public Optional<Employee> findById(Long id) {
        return employeeRepository.findById(id);
    }

    @Override
    public EmployeeDTO saveEmployee(EmployeeDTO employeeDTO) {
        return null;
    }

    @Override
    public EmployeeDTO updateEmployee(EmployeeDTO employeeDTO) {
        return null;
    }


    @Override
    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }
}