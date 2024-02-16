package com.management.department.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "departments")
@Data
@NoArgsConstructor
public class Department {
   
	@Id
	@Column(name = "dept_no")
//	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private String id;
	
	@Column(name = "dept_name")
	private String deptName;
}
