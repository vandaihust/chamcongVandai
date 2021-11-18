package com.vandai.mobi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vandai.mobi.model.Department;
import com.vandai.mobi.reponsitory.DepartmentRepository;
import com.vandai.mobi.services.impl.DepartmentServiceImpl;

@Service
public class DepartmentService implements DepartmentServiceImpl{
	@Autowired
	DepartmentRepository departmentRepository;
	@Override
	public Department addDepartment(Department department) {
		departmentRepository.save(department);
		return department;
	}

	@Override
	public List<Department> getAllDepartment() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Department getDepartmentById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteDepartment(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateDepartment(Department department, int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Department> getDepartmentByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
