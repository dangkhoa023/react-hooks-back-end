package com.javaproject.employeespringbootbackend.testing;

import com.javaproject.employeespringbootbackend.controller.SalaryController;
import com.javaproject.employeespringbootbackend.dto.SalaryDTO;
import com.javaproject.employeespringbootbackend.service.SalaryService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
class SalaryControllerTest {

    @Mock
    private SalaryService salaryService;

    @InjectMocks
    private SalaryController salaryController;

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(salaryController).build();
    }

    @Test
    void testGetAllSalaries() throws Exception {
        List<SalaryDTO> salaries = new ArrayList<>();
        //Thêm các đối tượng SalaryDTO vào danh sách salaries

        Mockito.when(salaryService.getAllSalaries()).thenReturn(salaries);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/salaries")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
        //Thêm kiểm tra kết quả dự kiến tại đây nếu cần
    }

    @Test
    void testGetSalaryById() throws Exception {
        Long salaryId = 1L;
        SalaryDTO salaryDTO = new SalaryDTO();
        //Thiết lập SalaryDTO và kiểm tra kết quả dự kiến

        Mockito.when(salaryService.getSalaryById(salaryId)).thenReturn(Optional.of(salaryDTO));

        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/salaries/{id}", salaryId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
        //Thêm kiểm tra kết quả dự kiến tại đây nếu cần
    }

    // Thêm các unit test cho các phương thức khác tương tự ở đây
    // testAddSalary, testUpdateSalary, testDeleteSalary, testGetSalariesByEmployeeId
}
