package com.javaproject.employeespringbootbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SalaryDTO {
    private Long id;
    private BigDecimal salaryAmount;
    private String currency;
    private String payPeriod;
    private LocalDate effectiveDate;
    private Long employeeId; // Thêm trường employeeId
    private String employeeFirstName; // Thêm trường employeeFirstName
    private String employeeLastName; // Thêm trường employeeLastName
    private String employeeEmailId; // Thêm trường employeeEmailId
}



