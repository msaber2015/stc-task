package com.stc.task.service;

import com.stc.task.common.dto.EmployeeDTO;
import com.stc.task.common.dto.GetEmployeesResponseDTO;
import com.stc.task.common.entity.Employee;
import com.stc.task.mapper.EmployeeMapper;
import com.stc.task.repository.EmployeeRepository;
import com.stc.task.specification.EmployeeSpecification;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper employeeMapper;

    public GetEmployeesResponseDTO getAll(Long id, String firstName, String lastName,
                                          String phone, String email, Double salary,
                                          Pageable pageable) {

        EmployeeSpecification employeeSpecification = EmployeeSpecification.builder()
                .email(email)
                .firstName(firstName)
                .lastName(lastName)
                .phone(phone)
                .email(email)
                .id(id)
                .salary(salary)
                .build();
        Page<Employee> employeesPage = employeeRepository.findAll(employeeSpecification, pageable);
        return employeeMapper.map(employeesPage);
    }

    public EmployeeDTO addEmployee(EmployeeDTO request) {

        Employee employee = employeeMapper.map(request);
        return employeeMapper.map(employeeRepository.save(employee));
    }

    public void removeEmployee(Long id) {
        employeeRepository.deleteById(id);
    }
}
