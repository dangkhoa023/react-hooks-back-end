package com.javaproject.employeespringbootbackend.mapper;

import com.javaproject.employeespringbootbackend.dto.SalaryDTO;
import com.javaproject.employeespringbootbackend.model.Employee;
import com.javaproject.employeespringbootbackend.model.Salary;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface SalaryMapper {
    @Mapping(target = "employeeId", source = "employee.id")
    @Mapping(target = "employeeFirstName", source = "employee.firstName")
    @Mapping(target = "employeeLastName", source = "employee.lastName")
    @Mapping(target = "employeeEmailId", source = "employee.emailId")
    @Mapping(target = "id", source = "salary.id") // Chỉ định nguồn dữ liệu cho trường 'id'
    SalaryDTO toDTO(Salary salary, Employee employee);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "employee", ignore = true)
    Salary toModel(SalaryDTO salaryDTO);
}


