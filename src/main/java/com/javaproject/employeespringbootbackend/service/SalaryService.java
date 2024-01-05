package com.javaproject.employeespringbootbackend.service;

import com.javaproject.employeespringbootbackend.dto.SalaryDTO;

import java.util.List;
import java.util.Optional;

public interface SalaryService {
    List<SalaryDTO> getAllSalaries();
    Optional<SalaryDTO> getSalaryById(Long id); // lấy thông tin lương
    SalaryDTO addSalary(SalaryDTO salaryDTO); // thêm
    SalaryDTO updateSalary(Long id, SalaryDTO salaryDTO); // cập nhật
    void deleteSalary(Long id);
    List<SalaryDTO> getSalariesByEmployeeId(Long employeeId);
}



