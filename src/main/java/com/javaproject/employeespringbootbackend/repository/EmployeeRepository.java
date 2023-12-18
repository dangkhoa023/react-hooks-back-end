package com.javaproject.employeespringbootbackend.repository;

import com.javaproject.employeespringbootbackend.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
