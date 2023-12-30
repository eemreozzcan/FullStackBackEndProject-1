package com.eemrezcn.example.service;

import com.eemrezcn.example.dto.DepartmentDto;

import java.util.List;

public interface DepartmentService
{
    DepartmentDto createDepartment(DepartmentDto departmentDto);

    DepartmentDto getDepartmentById(Long departmentId);

    List<DepartmentDto> getAllDepartments();

    DepartmentDto updateDepartment(Long departmentId, DepartmentDto updatedDepartment);

    void deleteDepartment(Long departmentId);
}
