package com.eemrezcn.example.controller;

import com.eemrezcn.example.dto.DepartmentDto;
import com.eemrezcn.example.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin(origins = {"http://localhost:3000"}) //It allows requests only from the source 'http://localhost:3000' to reach this Controller.
@AllArgsConstructor //It is a Lombok annotation that generates a constructor with a parameter for each field in your class.
@RestController //It is a convenience annotation that combines @Controller and @ResponseBody.
@RequestMapping("/api/departments") //It specifies the base path for all the APIs in this Controller.
public class DepartmentController
{
    //The DepartmentService object is injected into the DepartmentController class using the @AllArgsConstructor annotation.
    private  DepartmentService departmentService;

    //HTTP POST
    //http://localhost:8080/api/departments
    //A new department is created. The operation is performed using the DepartmentDto object sent by the client.
    // The details of the created department are returned as a response in the form of a DepartmentDto.
    @PostMapping
    public ResponseEntity<DepartmentDto> createDepartment(@RequestBody DepartmentDto departmentDto) {
        DepartmentDto savedDepartment = departmentService.createDepartment(departmentDto);
        return new ResponseEntity<>(savedDepartment, HttpStatus.CREATED);
    }

    // HTTP GET
    // http://localhost:8080/api/departments/1
    // The department with the given id is returned as a response in the form of a DepartmentDto.
    @GetMapping("{id}")
    public ResponseEntity<DepartmentDto> getDepartmentById(@PathVariable("id") Long departmentId) {
        DepartmentDto departmentDto = departmentService.getDepartmentById(departmentId);

        if (departmentDto != null) {
            return ResponseEntity.ok(departmentDto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    //HTTP GET
    //http://localhost:8080/api/departments
    //This code includes a Spring Boot Controller method used to retrieve all departments in response to an HTTP GET request
    @GetMapping
    public ResponseEntity<List<DepartmentDto>> getAllDepartments() {
        List<DepartmentDto> departments = departmentService.getAllDepartments();
        return ResponseEntity.ok(departments);
    }

    //HTTP PUT
    //http://localhost:8080/api/departments/1
    //The department with the given id is updated using the DepartmentDto object sent by the client.
    @PutMapping("{id}")
    public ResponseEntity<DepartmentDto> updateDepartment(@PathVariable("id") Long departmentId, @RequestBody DepartmentDto updatedDepartment) {
        DepartmentDto departmentDto = departmentService.updateDepartment(departmentId, updatedDepartment);
        return ResponseEntity.ok(departmentDto);
    }

    //HTTP DELETE
    //http://localhost:8080/api/departments/1
    //The department with the given id is deleted.
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteDepartment(@PathVariable("id") Long departmentId) {
        departmentService.deleteDepartment(departmentId);
        return ResponseEntity.ok("Department deleted successfully");
    }

}
