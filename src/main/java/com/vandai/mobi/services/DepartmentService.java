package com.vandai.mobi.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
		
		List<Department> listDepartment = departmentRepository.findAll();
		return listDepartment;
	}


	@Override
	public boolean deleteDepartment(Long id) {
		departmentRepository.deleteById(id);
		return true;
	}

	@Override
	public boolean updateDepartment(Department department, Long id) {
		
		Department departmentOld = departmentRepository.getById(id);
		if(department.getId()==departmentOld.getId()) {
			departmentRepository.save(department);			
			return true;
		}
		else return false;
	}

	@Override
	public List<Department> getDepartmentByName(String name) {
		List<Department> listDepartment = departmentRepository.findByNameIsContaining(name);
		return listDepartment;
	}

	@Override
	public Optional<Department> getDepartmentById(Long id) {
		Optional<Department> department = departmentRepository.findById(id);
		return department;
	}

	@Override
	public boolean deleteAllDepartment() {
		departmentRepository.deleteAll();
		return true;
	}

	@Override
	public boolean deleteDepartmentSelected(List<Long> id) {
		for (Long idStr : id) {
			if(departmentRepository.existsById(idStr) == true) {
				departmentRepository.deleteById(idStr);
			}
			return true;
		}
		return false;
	}

	@Override
	public List<Department> fakeDataDepartment() {
		List<Department> list = new ArrayList<Department>();
		for(long i = 1; i < 6; i++) {
			Department department = new Department();
			department.setIdDepartment("PB0"+i);
			department.setName("Phòng ban số "+i);
			list.add(department);
			departmentRepository.save(department);			
		}
		return list;
	}
	
}
