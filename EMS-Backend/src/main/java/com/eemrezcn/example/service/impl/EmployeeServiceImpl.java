package com.eemrezcn.example.service.impl;

import com.eemrezcn.example.dto.EmployeeDto;
import com.eemrezcn.example.entity.Employee;
import com.eemrezcn.example.exception.ResourceNotFoundException;
import com.eemrezcn.example.mapper.EmployeeMapper;
import com.eemrezcn.example.repository.EmployeeRepository;
import com.eemrezcn.example.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service // Spring will create an instance of this class as a bean in the application context.
@AllArgsConstructor // Lombok will generate a constructor with a parameter for each field in your class.
public class EmployeeServiceImpl implements EmployeeService
{
    // The class has a dependency on the EmployeeRepository interface.
    private EmployeeRepository employeeRepository;


    //This code represents a service method that creates an employee using an EmployeeDto object
    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
        Employee savedEmployee = employeeRepository.save(employee);
        return EmployeeMapper.mapEmployeeToDto(savedEmployee);
    }

    //This code represents a service method that returns an employee by id
    @Override
    public EmployeeDto getEmployeeById(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee is not exists with given id:: " + employeeId));
        return EmployeeMapper.mapEmployeeToDto(employee);
    }

    //This code represents a service method that returns all employees
    @Override
    public List<EmployeeDto> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        return employees.stream().map((employee) ->EmployeeMapper.mapEmployeeToDto(employee))
                .collect(Collectors.toList());
    }

    //This code represents a service method that updates an employee by id
    @Override
    public EmployeeDto updateEmployee(Long employeeId, EmployeeDto updatedEmployeeDto) {

        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee is not exists with given id:: " + employeeId)
                );

        employee.setFirstName(updatedEmployeeDto.getFirstName());
        employee.setLastName(updatedEmployeeDto.getLastName());
        employee.setEmail(updatedEmployeeDto.getEmail());

        Employee updatedEmployeeObj = employeeRepository.save(employee);

        return EmployeeMapper.mapEmployeeToDto(updatedEmployeeObj);
    }

    //This code represents a service method that deletes an employee by id
    @Override
    public void deleteEmployee(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee is not exists with given id:: " + employeeId)
                );
        employeeRepository.delete(employee);
    }
}
