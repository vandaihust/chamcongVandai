package com.vandai.mobi.services.impl;

import java.util.List;

import com.vandai.mobi.model.Salary;

public interface SalaryServiceImpl {
	public Salary addSalary(Salary salary);
	public List<Salary> getAllSalary();
	public Salary updateSalary(int coefficientsSalary, double basicSalary);
	public String deleteSalary(int id);
	public Salary getSalaryById(int id);
	public List<Salary> fakeDataSalary();
}
