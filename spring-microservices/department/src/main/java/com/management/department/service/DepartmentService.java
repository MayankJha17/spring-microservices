package com.management.department.service;

import org.springframework.http.ResponseEntity;

public interface DepartmentService {
	
	
	public ResponseEntity<?> getDepartmentById(String deptId);

}
