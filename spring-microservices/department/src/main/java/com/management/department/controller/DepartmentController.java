package com.management.department.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.management.department.service.DepartmentService;

@RestController
@RequestMapping("/api/departments")
public class DepartmentController {
	
	@Autowired
	DepartmentService service;
	
	
	@GetMapping(value = "/get/{id}")
	public ResponseEntity<?> getDepartmentbyId(@PathVariable("id") String deptId){
		
		return service.getDepartmentById(deptId);
		
	}
 
}
