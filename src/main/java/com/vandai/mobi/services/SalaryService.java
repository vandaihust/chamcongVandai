package com.vandai.mobi.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vandai.mobi.model.Salary;
import com.vandai.mobi.reponsitory.SalaryRepository;
import com.vandai.mobi.services.impl.SalaryServiceImpl;
@Service
public class SalaryService implements SalaryServiceImpl{

	@Autowired
	SalaryRepository salaryRepository;
	@Override
	public Salary addSalary(Salary salary) {
		salaryRepository.save(salary);
		return salary;
	}

	@Override
	public List<Salary> getAllSalary() {
		List<Salary> listSalaries = salaryRepository.findAll();
		return listSalaries;
	}

	@Override
	public Salary updateSalary(int coefficientsSalary, double basicSalary) {
		salaryRepository.findById(coefficientsSalary).get().setBasicSalary(basicSalary);
		return salaryRepository.findById(coefficientsSalary).get();
	}

	@Override
	public String deleteSalary(int id) {
		if(salaryRepository.existsById(id)) {
			salaryRepository.deleteById(id);
			return "Delete salary success";

		}
		return "Delete salary fail";
	}

	@Override
	public List<Salary> fakeDataSalary() {
		List<Salary> list = new ArrayList<Salary>();
		for(int i = 0; i < 10; i++) {
			Salary salary = new Salary();
			salary.setCoefficientsSalary(i);
			salary.setBasicSalary(Double.parseDouble(String.valueOf(i)+"000000"));
			list.add(salary);
			salaryRepository.save(salary);
		}
		return list;
	}

	@Override
	public Salary getSalaryById(int id) {
		Salary salary = salaryRepository.findById(id).get();
		return salary;
	}

}
