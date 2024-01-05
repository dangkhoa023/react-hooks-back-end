package com.javaproject.employeespringbootbackend.controller;

import com.javaproject.employeespringbootbackend.dto.SalaryDTO;
import com.javaproject.employeespringbootbackend.service.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/salaries")
public class SalaryController {

    @Autowired
    private SalaryService salaryService;

    // get tất cả lương
    @GetMapping
    public List<SalaryDTO> getAllSalaries() {
        return salaryService.getAllSalaries();
    }


    // get lương bằng id
    @GetMapping("/{id}")
    public SalaryDTO getSalaryById(@PathVariable Long id) {
        Optional<SalaryDTO> resultOptional = salaryService.getSalaryById(id);
        return resultOptional.orElse(null);
    }

    //thêm lương
    @PostMapping
    public SalaryDTO addSalary(@RequestBody SalaryDTO salaryDTO) {
        return salaryService.addSalary(salaryDTO);
    }

    // update lương
    @PutMapping("/{id}")
    public SalaryDTO updateSalary(@PathVariable Long id, @RequestBody SalaryDTO salaryDTO) {
        return salaryService.updateSalary(id, salaryDTO);
    }

    // xóa
    @DeleteMapping("/{id}")
    public void deleteSalary(@PathVariable Long id) {
        salaryService.deleteSalary(id);
    }

    @GetMapping("/employee/{employeeId}")
    public List<SalaryDTO> getSalariesByEmployeeId(@PathVariable Long employeeId) {
        return salaryService.getSalariesByEmployeeId(employeeId);
    }
}


