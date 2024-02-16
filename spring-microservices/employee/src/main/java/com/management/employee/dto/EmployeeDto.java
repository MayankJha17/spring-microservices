package com.management.employee.dto;

import java.sql.Date;

import com.management.employee.model.Gender;

import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class EmployeeDto {

	private int id;

	private Date birthDate;

	private String firstName;

	private String lastName;

	private Gender gender;

	private Date hireDate;

	private boolean status=false;

	private String message="";

}
