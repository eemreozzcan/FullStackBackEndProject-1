package com.eemrezcn.example.mapper;

import com.eemrezcn.example.dto.DepartmentDto;
import com.eemrezcn.example.entity.Department;

public class DepartmentMapper
{
    //convert deparment jpa entity to department dto
    public static DepartmentDto mapDepartmentToDto(Department department)
    {
        return new DepartmentDto(
            department.getId(),
            department.getDepartmentName(),
            department.getDepartmentDescription()
        );
    }

    //convert department dto to department jpa entity
    public static Department mapToDepartment(DepartmentDto departmentDto)
    {
        return new Department(
            departmentDto.getId(),
            departmentDto.getDepartmentName(),
            departmentDto.getDepartmentDescription()
        );
    }
}
