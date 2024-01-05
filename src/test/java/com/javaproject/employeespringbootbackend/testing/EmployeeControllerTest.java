package com.javaproject.employeespringbootbackend.testing;

import com.javaproject.employeespringbootbackend.controller.EmployeeController;
import com.javaproject.employeespringbootbackend.model.Employee;
import com.javaproject.employeespringbootbackend.repository.EmployeeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
class EmployeeControllerTest {

    @Mock
    private EmployeeRepository employeeRepository;

    @InjectMocks
    private EmployeeController employeeController;

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(employeeController).build();
    }

    @Test
    void testGetAllEmployees() throws Exception {
        List<Employee> employees = new ArrayList<>();
        //Thêm các đối tượng Employee vào danh sách employees

        Mockito.when(employeeRepository.findAll()).thenReturn(employees);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/employess")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
        //Thêm kiểm tra kết quả dự kiến tại đây nếu cần
    }

    @Test
    void testCreateEmployee() throws Exception {
        Employee employee = new Employee();
        //Thiết lập Employee và kiểm tra kết quả dự kiến

        Mockito.when(employeeRepository.save(Mockito.any(Employee.class))).thenReturn(employee);

        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/employess")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{}")) // Thêm dữ liệu JSON tương ứng với đối tượng Employee
                .andExpect(MockMvcResultMatchers.status().isOk());
        //Thêm kiểm tra kết quả dự kiến tại đây nếu cần
    }

    @Test
    void testGetEmployeeById() throws Exception {
        long employeeId = 1L;
        Employee employee = new Employee();
        //Thiết lập Employee và kiểm tra kết quả dự kiến

        Mockito.when(employeeRepository.findById(employeeId)).thenReturn(Optional.of(employee));

        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/employess/{id}", employeeId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
        //Thêm kiểm tra kết quả dự kiến tại đây nếu cần
    }

    @Test
    void testUpdateEmployee() throws Exception {
        long employeeId = 1L;
        Employee employeeDetails = new Employee();
        //Thiết lập Employee và kiểm tra kết quả dự kiến

        Mockito.when(employeeRepository.findById(employeeId)).thenReturn(Optional.of(new Employee()));
        Mockito.when(employeeRepository.save(Mockito.any(Employee.class))).thenReturn(employeeDetails);

        mockMvc.perform(MockMvcRequestBuilders.put("/api/v1/employess/{id}", employeeId)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{}")) // Thêm dữ liệu JSON tương ứng với đối tượng Employee
                .andExpect(MockMvcResultMatchers.status().isOk());
        //Thêm kiểm tra kết quả dự kiến tại đây nếu cần
    }

    @Test
    void testDeleteEmployee() throws Exception {
        long employeeId = 1L;

        Mockito.when(employeeRepository.findById(employeeId)).thenReturn(Optional.of(new Employee()));

        mockMvc.perform(MockMvcRequestBuilders.delete("/api/v1/employess/{id}", employeeId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isNoContent());
        //Thêm kiểm tra kết quả dự kiến tại đây nếu cần
    }
}
