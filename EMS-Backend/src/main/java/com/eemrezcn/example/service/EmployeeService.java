package com.eemrezcn.example.service;

import com.eemrezcn.example.dto.EmployeeDto;

import java.util.List;

public interface EmployeeService
{
    EmployeeDto createEmployee(EmployeeDto employeeDto);

    EmployeeDto getEmployeeById(Long employeeId);

    List<EmployeeDto> getAllEmployees();

    EmployeeDto updateEmployee(Long employeeId, EmployeeDto updatedEmployeeDto);

    void deleteEmployee(Long employeeId);

}
