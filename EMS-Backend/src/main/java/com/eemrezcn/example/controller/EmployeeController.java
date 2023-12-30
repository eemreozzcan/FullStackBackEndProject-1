package com.eemrezcn.example.controller;

import com.eemrezcn.example.dto.EmployeeDto;
import com.eemrezcn.example.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:3000"}) //It allows requests only from the source 'http://localhost:3000' to reach this Controller.
@AllArgsConstructor //It is a Lombok annotation that generates a constructor with a parameter for each field in your class.
@RestController //It is a convenience annotation that combines @Controller and @ResponseBody.
@RequestMapping("/api/employees") //It specifies the base path for all the APIs in this Controller.
public class EmployeeController
{
    //The EmployeeService object is injected into the EmployeeController class using the @AllArgsConstructor annotation.
    private EmployeeService employeeService;

    //HTTP POST
    //http://localhost:8080/api/employees
    //A new employee is created. The operation is performed using the EmployeeDto object sent by the client.
    @PostMapping
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto) {
        EmployeeDto savedEmployee = employeeService.createEmployee(employeeDto);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    //HTTP GET
    //http://localhost:8080/api/employees/1
    //The employee with the given id is returned as a response in the form of a EmployeeDto.
    @GetMapping("{id}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable("id") Long employeeId) {
        EmployeeDto employeeDto = employeeService.getEmployeeById(employeeId);
        return ResponseEntity.ok(employeeDto);
    }

    //HTTP GET
    //http://localhost:8080/api/employees
    //This code includes a Spring Boot Controller method used to retrieve all employees in response to an HTTP GET request
    @GetMapping
    public ResponseEntity<List<EmployeeDto>> getAllEmployees() {
        List<EmployeeDto> employees= employeeService.getAllEmployees();
        return ResponseEntity.ok(employees);
    }

    //HTTP PUT
    //http://localhost:8080/api/employees/1
    //The employee with the given id is updated using the EmployeeDto object sent by the client.
    @PutMapping("{id}")
    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable("id") Long employeeId,
                                                      @RequestBody EmployeeDto updatedEmployeeDto) {
        EmployeeDto updatedEmployee = employeeService.updateEmployee(employeeId, updatedEmployeeDto);
        return ResponseEntity.ok(updatedEmployee);
    }

    //HTTP DELETE
    //http://localhost:8080/api/employees/1
    //The employee with the given id is deleted.
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") Long employeeId) {
        employeeService.deleteEmployee(employeeId);
        return ResponseEntity.ok("Employee deleted successfully");
    }

}
