package com.vandai.mobi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vandai.mobi.dto.EmployeeDto;
import com.vandai.mobi.model.Employee;
import com.vandai.mobi.services.DepartmentService;
import com.vandai.mobi.services.EmployeeService;
import com.vandai.mobi.services.UserService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/employee")
public class EmployeeController {
	@Autowired
	EmployeeService employeeService;
	@Autowired
	DepartmentService departmentService;
	@Autowired
	UserService userService; 
	@GetMapping
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> getAllEmployees(){
		return new ResponseEntity<List<Employee>>(employeeService.getAllEmployees()
				,HttpStatus.OK);
	}
	@PostMapping
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> addEmployee(@RequestBody EmployeeDto employeeDto){		
		return new ResponseEntity<Employee>(employeeService.addEmployee(employeeDto)
				,HttpStatus.OK);
	}
}
