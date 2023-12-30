package com.eemrezcn.example.mapper;

import com.eemrezcn.example.dto.EmployeeDto;
import com.eemrezcn.example.entity.Employee;

public class EmployeeMapper
{
    //convert employee jpa entity to employee dto
    public static EmployeeDto mapEmployeeToDto(Employee employee)
    {
        return new EmployeeDto(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail()
        );
    }
    //convert employee dto to employee jpa entity
    public static Employee mapToEmployee(EmployeeDto employeeDto)
    {
        return new Employee(
                employeeDto.getId(),
                employeeDto.getFirstName(),
                employeeDto.getLastName(),
                employeeDto.getEmail()
        );
    }
}
