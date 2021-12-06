package com.vandai.mobi.services.impl;

import java.sql.Date;
import java.util.List;

import com.vandai.mobi.model.AddSubSalary;

public interface AddSubSalaryServiceImpl {
	public AddSubSalary addAddSubSalary(long idEmployee, AddSubSalary addSubSalary);
	public AddSubSalary updateAddSubSalary(long idEmployee, long idAddSubSalary, AddSubSalary addSubSalary);
	public String deleteAddSubSalary(long idAddSubSalary);
	public List<AddSubSalary> getByCategory(int category);
	public List<AddSubSalary> getByDate(Date date);
	public List<AddSubSalary> getByEmployee(long idEmployee);
	public AddSubSalary getAddSubSalaryById(long id);
}
