package com.management.department.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.management.department.dto.DepartmentDto;
import com.management.department.mapper.DepartmentMapper;
import com.management.department.model.Department;
import com.management.department.repostories.DepartmentRepository;
import com.management.department.service.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	DepartmentRepository repository;

	@Override
	public ResponseEntity<?> getDepartmentById(String deptId) {

		DepartmentDto departmentDto = null;
		try {

			Optional<Department> optDepartment = repository.findById(deptId);

			if (optDepartment.isPresent()) {

				departmentDto = DepartmentMapper.INSTANCE.mapToDepartmentDto(optDepartment.get());
				departmentDto.setStatus(true);
				departmentDto.setMessage("Result SuccessFul");
				return new ResponseEntity<>(departmentDto, HttpStatus.OK);
			}

			else {

				departmentDto = new DepartmentDto();
				departmentDto.setStatus(true);
				departmentDto.setMessage("Not Found");
				return new ResponseEntity<>(departmentDto, HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			e.printStackTrace();
			departmentDto = new DepartmentDto();
			departmentDto.setStatus(false);
			departmentDto.setMessage("Not Found");
			return new ResponseEntity<>(departmentDto, HttpStatus.NOT_FOUND);

		}

	}

}
