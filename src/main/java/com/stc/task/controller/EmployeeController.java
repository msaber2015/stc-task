package com.stc.task.controller;


import com.stc.task.common.dto.EmployeeDTO;
import com.stc.task.common.dto.GetEmployeesResponseDTO;
import com.stc.task.service.EmployeeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping
    public GetEmployeesResponseDTO getAll(@RequestParam(required = false) Long id,
                                          @RequestParam(required = false) String firstName,
                                          @RequestParam(required = false) String lastName,
                                          @RequestParam(required = false) String phone,
                                          @RequestParam(required = false) String email,
                                          @RequestParam(required = false) Double salary,
                                          @RequestParam(defaultValue = "ASC") Sort.Direction direction,
                                          @RequestParam(defaultValue = "id") String sortElement,
                                          @RequestParam(defaultValue = "0") int pageNumber,
                                          @RequestParam(defaultValue = "10") int pageSize) {
        return employeeService.getAll(id, firstName, lastName, phone, email, salary,
                PageRequest.of(pageNumber, pageSize, direction, sortElement));
    }

    @PostMapping
    public EmployeeDTO addEmployee(@RequestBody @Valid EmployeeDTO request) {
        return employeeService.addEmployee(request);
    }

    @DeleteMapping("/{id}")
    public void removeEmployee(@PathVariable Long id) {
        employeeService.removeEmployee(id);
    }
}
