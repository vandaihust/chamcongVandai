package com.vandai.mobi.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.vandai.mobi.model.Department;

public interface DepartmentServiceImpl {
	public Department addDepartment(Department department);
	public List<Department> getAllDepartment();
	public Department getDepartmentById(int id);      
	public boolean deleteDepartment(int id);     
	public boolean updateDepartment(Department department, int id); 
	public List<Department> getDepartmentByName(String name); 
}
