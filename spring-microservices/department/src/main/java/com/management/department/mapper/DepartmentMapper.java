package com.management.department.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import com.management.department.dto.DepartmentDto;
import com.management.department.model.Department;

@Mapper
public interface DepartmentMapper {
	
	
	DepartmentMapper INSTANCE = Mappers.getMapper(DepartmentMapper.class);
	
	@Mappings({
        @Mapping(target = "message", ignore =  true),
        @Mapping(target = "status", ignore = true)
    })
	DepartmentDto mapToDepartmentDto(Department department);
	
	Department mapToDepartment(DepartmentDto departmentDto);

}
