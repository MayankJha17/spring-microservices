package com.management.department.repostories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.management.department.model.Department;

public interface DepartmentRepository  extends JpaRepository<Department, String>{
	
	
    
	
}
