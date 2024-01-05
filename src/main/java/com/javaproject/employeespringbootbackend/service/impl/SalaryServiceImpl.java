package com.javaproject.employeespringbootbackend.service.impl;

import com.javaproject.employeespringbootbackend.dto.SalaryDTO;
import com.javaproject.employeespringbootbackend.model.Salary;
import com.javaproject.employeespringbootbackend.repository.SalaryRepository;
import com.javaproject.employeespringbootbackend.service.SalaryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SalaryServiceImpl implements SalaryService {

    @Autowired
    private SalaryRepository salaryRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<SalaryDTO> getAllSalaries() {
        return salaryRepository.findAll().stream()
                .map(salary -> modelMapper.map(salary, SalaryDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<SalaryDTO> getSalaryById(Long id) {
        return salaryRepository.findById(id).map(salary -> modelMapper.map(salary, SalaryDTO.class));
    }

    @Override
    public SalaryDTO addSalary(SalaryDTO salaryDTO) {
        Salary salary = modelMapper.map(salaryDTO, Salary.class);
        Salary savedSalary = salaryRepository.save(salary);
        return modelMapper.map(savedSalary, SalaryDTO.class);
    }

    @Override
    public SalaryDTO updateSalary(Long id, SalaryDTO salaryDTO) {
        if (salaryRepository.existsById(id)) {
            Salary updatedSalary = modelMapper.map(salaryDTO, Salary.class);
            updatedSalary.setId(id);
            Salary savedSalary = salaryRepository.save(updatedSalary);
            return modelMapper.map(savedSalary, SalaryDTO.class);
        }
        return null;
    }

    @Override
    public void deleteSalary(Long id) {
        salaryRepository.deleteById(id);
    }

    @Override
    public List<SalaryDTO> getSalariesByEmployeeId(Long employeeId) {
        return salaryRepository.findByEmployeeId(employeeId).stream()
                .map(salary -> modelMapper.map(salary, SalaryDTO.class))
                .collect(Collectors.toList());
    }
}





