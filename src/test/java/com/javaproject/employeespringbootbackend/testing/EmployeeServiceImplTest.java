package com.javaproject.employeespringbootbackend.testing;

import com.javaproject.employeespringbootbackend.model.Employee;
import com.javaproject.employeespringbootbackend.repository.EmployeeRepository;
import com.javaproject.employeespringbootbackend.service.impl.EmployeeServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
class EmployeeServiceImplTest {

    @Mock
    private EmployeeRepository employeeRepository;

    @InjectMocks
    private EmployeeServiceImpl employeeService;

    @Test
    void testFindAllEmployee() {
        List<Employee> employees = new ArrayList<>();
        // Thêm các đối tượng Employee vào danh sách employees

        Mockito.when(employeeRepository.findAll()).thenReturn(employees);

        List<Employee> result = employeeService.findAllEmployee();

        assertEquals(employees, result);
    }

    @Test
    void testFindById() {
        Long employeeId = 1L;
        Employee employee = new Employee();
        // Thiết lập Employee và kiểm tra kết quả dự kiến

        Mockito.when(employeeRepository.findById(employeeId)).thenReturn(Optional.of(employee));

        Optional<Employee> result = employeeService.findById(employeeId);

        assertTrue(result.isPresent());
        assertEquals(employee, result.get());
    }





    @Test
    void testDeleteEmployee() {
        Long employeeId = 1L;

        // Gọi phương thức deleteEmployee từ service
        employeeService.deleteEmployee(employeeId);

        // Sử dụng Mockito để kiểm tra xem phương thức deleteById đã được gọi với đúng đối số chưa
        Mockito.verify(employeeRepository, Mockito.times(1)).deleteById(employeeId);
    }
}

