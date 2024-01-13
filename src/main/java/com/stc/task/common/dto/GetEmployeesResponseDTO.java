package com.stc.task.common.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetEmployeesResponseDTO {
    private long totalPages;
    private long totalElements;
    private int number;
    private int size;
    private int numberOfElements;
    private List<EmployeeDTO> employees;
}
