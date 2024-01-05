package com.javaproject.employeespringbootbackend.model;

import jakarta.persistence.*;
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
@Entity
@Table(name = "salaries")
public class Salary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @Column(name = "salary_amount")
    private BigDecimal salaryAmount;

    @Column(name = "currency")
    private String currency;

    @Column(name = "pay_period")
    private String payPeriod;

    @Column(name = "effective_date")
    private LocalDate effectiveDate;
}

