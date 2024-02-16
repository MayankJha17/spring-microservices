package com.management.department.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DepartmentDto {
	

	private String id;

	private String deptName;
	
	private String message;
	
	private boolean status;

}
