package com.management.employee.serviceImpl;

import com.management.employee.dto.EmployeeDto;
import com.management.employee.mapper.EmployeeMapper;
import com.management.employee.model.Employee;
import com.management.employee.repositories.EmployeeRepository;
import com.management.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class EmployeeSercviceImpl implements EmployeeService {

    @Autowired
    EmployeeRepository repo;


    @Override
    public ResponseEntity<?> getEmployeebyId(int empNo) {

        try {
        Optional<Employee> optEmployee = repo.findById(empNo);

        EmployeeDto employeeDto = null;
        ResponseEntity<EmployeeDto> responseEntity = null;

        if(optEmployee.isPresent())
        {
            employeeDto = EmployeeMapper.INSTANCE.mapToEmployeeDto(optEmployee.get());
            employeeDto.setStatus(true);
            employeeDto.setMessage("Fetched Successfully");
            responseEntity = new ResponseEntity<>(employeeDto , HttpStatus.OK);
            return responseEntity;
        }

        else{

            employeeDto = new EmployeeDto();

            employeeDto.setStatus(false);
            employeeDto.setMessage("Data not found");
            responseEntity = new ResponseEntity<>(employeeDto , HttpStatus.NOT_FOUND);

            return responseEntity;

        }
        
        }catch(Exception e) {
        	
        	e.printStackTrace();
        	
        	EmployeeDto employeeDto = new EmployeeDto();

            employeeDto.setStatus(false);
            employeeDto.setMessage("Data not found");
        	return new ResponseEntity<>(employeeDto , HttpStatus.NOT_FOUND);

        	
        }
        



    }
}
