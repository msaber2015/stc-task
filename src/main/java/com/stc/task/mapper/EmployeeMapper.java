package com.stc.task.mapper;

import com.stc.task.common.dto.EmployeeDTO;
import com.stc.task.common.dto.GetEmployeesResponseDTO;
import com.stc.task.common.entity.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.springframework.data.domain.Page;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface EmployeeMapper {
    EmployeeDTO map(Employee employee);

    Employee map(EmployeeDTO employeeDTO);

    @Mapping(source = "content", target = "employees")
    GetEmployeesResponseDTO map(Page<Employee> employeePage);
}
