package com.management.employee.service;

import org.springframework.http.ResponseEntity;

public interface EmployeeService {


    ResponseEntity<?> getEmployeebyId(int empId);
}
