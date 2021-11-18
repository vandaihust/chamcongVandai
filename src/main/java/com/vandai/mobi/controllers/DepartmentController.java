package com.vandai.mobi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vandai.mobi.model.Department;
import com.vandai.mobi.services.DepartmentService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/department")
public class DepartmentController {
	@Autowired
	DepartmentService departmentService;
	@PostMapping("add")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> addDepartment(@RequestBody Department department){
		return new ResponseEntity<Department>(departmentService.addDepartment(department)
				, HttpStatus.OK);
	}
}
