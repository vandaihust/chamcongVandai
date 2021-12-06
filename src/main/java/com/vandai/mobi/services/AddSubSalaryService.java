package com.vandai.mobi.services;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vandai.mobi.model.AddSubSalary;
import com.vandai.mobi.model.Employee;
import com.vandai.mobi.reponsitory.AddSubSalaryRepository;
import com.vandai.mobi.reponsitory.EmployeeRepository;
import com.vandai.mobi.services.impl.AddSubSalaryServiceImpl;
@Service
public class AddSubSalaryService implements AddSubSalaryServiceImpl{
	@Autowired
	AddSubSalaryRepository addSubSalaryRepository;
	@Autowired
	EmployeeRepository employeeRepository;
	@Override
	public AddSubSalary addAddSubSalary(long idEmployee, AddSubSalary addSubSalary) {
		addSubSalary.setEmployee(employeeRepository.findById(idEmployee).get());
		addSubSalaryRepository.save(addSubSalary);
		
		return addSubSalary;
	}

	@Override
	public AddSubSalary updateAddSubSalary(long idEmployee, long idAddSubSalary, AddSubSalary addSubSalary) {
		Employee employee = employeeRepository.findById(idEmployee).get();
		addSubSalary.setId(idAddSubSalary);
		addSubSalary.setEmployee(employee);
		addSubSalaryRepository.save(addSubSalary);
		return addSubSalary;
	}

	@Override
	public String deleteAddSubSalary(long idAddSubSalary) {
		if(addSubSalaryRepository.existsById(idAddSubSalary)) {
			addSubSalaryRepository.deleteById(idAddSubSalary);
			return "Delete addSubSalary successfully";
		} 
		return "Delete fail";
	}

	@Override
	public List<AddSubSalary> getByCategory(int category) {
		List<AddSubSalary> list = addSubSalaryRepository.findByCategory(category);
		return list;
	}

	@Override
	public List<AddSubSalary> getByDate(Date date) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AddSubSalary> getByEmployee(long idEmployee) {
		List<AddSubSalary> addSubSalaries = addSubSalaryRepository.findByEmployee(employeeRepository.findById(idEmployee).get());
		return addSubSalaries;
	}

	@Override
	public AddSubSalary getAddSubSalaryById(long id) {
		AddSubSalary addSubSalary = addSubSalaryRepository.findById(id).get();
		if(addSubSalary!=null) {
			return addSubSalary;
		}
		return null;
	}

}
