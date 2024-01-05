package com.javaproject.employeespringbootbackend.testing;

import com.javaproject.employeespringbootbackend.dto.SalaryDTO;
import com.javaproject.employeespringbootbackend.model.Salary;
import com.javaproject.employeespringbootbackend.repository.SalaryRepository;
import com.javaproject.employeespringbootbackend.service.impl.SalaryServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
class SalaryServiceImplTest {

    @Mock
    private SalaryRepository salaryRepository;

    @Mock
    private ModelMapper modelMapper;

    @InjectMocks
    private SalaryServiceImpl salaryService;

    @Test
    void testGetAllSalaries() {
        List<Salary> salaries = new ArrayList<>();
        // Thêm các đối tượng Salary vào danh sách salaries

        Mockito.when(salaryRepository.findAll()).thenReturn(salaries);
        Mockito.when(modelMapper.map(Mockito.any(Salary.class), Mockito.eq(SalaryDTO.class)))
                .thenReturn(new SalaryDTO()); // Mô phỏng ánh xạ từ Salary sang SalaryDTO

        List<SalaryDTO> result = salaryService.getAllSalaries();

        assertEquals(salaries.size(), result.size());
    }

    @Test
    void testGetSalaryById() {
        Long salaryId = 1L;
        Salary salary = new Salary();
        // Thiết lập Salary và kiểm tra kết quả dự kiến

        Mockito.when(salaryRepository.findById(salaryId)).thenReturn(Optional.of(salary));
        Mockito.when(modelMapper.map(Mockito.any(Salary.class), Mockito.eq(SalaryDTO.class)))
                .thenReturn(new SalaryDTO()); // Mô phỏng ánh xạ từ Salary sang SalaryDTO

        Optional<SalaryDTO> result = salaryService.getSalaryById(salaryId);

        assertTrue(result.isPresent());
    }

    @Test
    void testAddSalary() {
        SalaryDTO salaryDTO = new SalaryDTO();
        // Thiết lập SalaryDTO và kiểm tra kết quả dự kiến

        Salary salary = new Salary();
        Mockito.when(modelMapper.map(salaryDTO, Salary.class)).thenReturn(salary);
        Mockito.when(salaryRepository.save(salary)).thenReturn(salary);
        Mockito.when(modelMapper.map(salary, SalaryDTO.class)).thenReturn(new SalaryDTO());

        SalaryDTO result = salaryService.addSalary(salaryDTO);

        assertEquals(salaryDTO, result);
    }

    @Test
    void testUpdateSalary() {
        Long salaryId = 1L;
        SalaryDTO salaryDTO = new SalaryDTO();
        // Thiết lập SalaryDTO và kiểm tra kết quả dự kiến

        Salary existingSalary = new Salary();
        Mockito.when(salaryRepository.existsById(salaryId)).thenReturn(true);
        Mockito.when(modelMapper.map(salaryDTO, Salary.class)).thenReturn(existingSalary);
        Mockito.when(salaryRepository.save(existingSalary)).thenReturn(existingSalary);
        Mockito.when(modelMapper.map(existingSalary, SalaryDTO.class)).thenReturn(new SalaryDTO());

        SalaryDTO result = salaryService.updateSalary(salaryId, salaryDTO);

        assertEquals(salaryDTO, result);
    }

    @Test
    void testDeleteSalary() {
        Long salaryId = 1L;

        // Gọi phương thức deleteSalary từ service
        salaryService.deleteSalary(salaryId);

        // Sử dụng Mockito để kiểm tra xem phương thức deleteById đã được gọi với đúng đối số chưa
        Mockito.verify(salaryRepository, Mockito.times(1)).deleteById(salaryId);
    }

    @Test
    void testGetSalariesByEmployeeId() {
        Long employeeId = 1L;
        List<Salary> salaries = new ArrayList<>();
        // Thêm các đối tượng Salary vào danh sách salaries

        Mockito.when(salaryRepository.findByEmployeeId(employeeId)).thenReturn(salaries);
        Mockito.when(modelMapper.map(Mockito.any(Salary.class), Mockito.eq(SalaryDTO.class)))
                .thenReturn(new SalaryDTO()); // Mô phỏng ánh xạ từ Salary sang SalaryDTO

        List<SalaryDTO> result = salaryService.getSalariesByEmployeeId(employeeId);

        assertEquals(salaries.size(), result.size());
    }
}

