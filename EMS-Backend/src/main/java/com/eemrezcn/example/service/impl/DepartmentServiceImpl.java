package com.eemrezcn.example.service.impl;

import com.eemrezcn.example.dto.DepartmentDto;
import com.eemrezcn.example.entity.Department;
import com.eemrezcn.example.exception.ResourceNotFoundException;
import com.eemrezcn.example.mapper.DepartmentMapper;
import com.eemrezcn.example.repository.DepartmentRepository;
import com.eemrezcn.example.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service // Spring will create an instance of this class as a bean in the application context.
@AllArgsConstructor // Lombok will generate a constructor with a parameter for each field in your class.
public class DepartmentServiceImpl  implements DepartmentService // The class implements the interface.
{
    // The class has a dependency on the DepartmentRepository interface.
    private DepartmentRepository departmentRepository;

    //This code represents a service method that creates a department using a DepartmentDto object
    @Override
    public DepartmentDto createDepartment(DepartmentDto departmentDto) {
        Department department = DepartmentMapper.mapToDepartment(departmentDto);
        Department savedDepartment = departmentRepository.save(department);
        return DepartmentMapper.mapDepartmentToDto(savedDepartment);
    }

    //This code represents a service method that returns a department by id
    @Override
    public DepartmentDto getDepartmentById(Long departmentId) {
        Department department = departmentRepository.findById(departmentId)
                .orElseThrow(() -> new RuntimeException("Department is not exists with given id:: " + departmentId));

        return DepartmentMapper.mapDepartmentToDto(department);
    }

    //This code represents a service method that returns all departments
    @Override
    public List<DepartmentDto> getAllDepartments() {
        List<Department> departments = departmentRepository.findAll();
        return departments.stream().map((department) ->DepartmentMapper.mapDepartmentToDto(department)).collect(Collectors.toList());
    }

    //This code represents a service method that updates a department by id
    @Override
    public DepartmentDto updateDepartment(Long departmentId, DepartmentDto updatedDepartment) {
        Department department =departmentRepository.findById(departmentId)
                .orElseThrow(() -> new ResourceNotFoundException("Department is not exists with given id:: " + departmentId));
        department.setDepartmentName(updatedDepartment.getDepartmentName());
        department.setDepartmentDescription(updatedDepartment.getDepartmentDescription());
        Department savedDepartment = departmentRepository.save(department);
        return DepartmentMapper.mapDepartmentToDto(savedDepartment);
    }

    //This code represents a service method that deletes a department by id
    @Override
    public void deleteDepartment(Long departmentId) {
        Department department = departmentRepository.findById(departmentId)
                .orElseThrow(() -> new ResourceNotFoundException("Department is not exists with given id:: " + departmentId));
        departmentRepository.delete(department);
    }
}
