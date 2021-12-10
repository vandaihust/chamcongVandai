package com.vandai.mobi.services.impl;

import java.sql.Date;
import java.util.List;

import com.vandai.mobi.dto.InsuranceDto;
import com.vandai.mobi.model.Employee;
import com.vandai.mobi.model.Insurance;

public interface InsuranceServiceImpl {
	public Insurance addInsurance(long idEmployee, InsuranceDto insuranceDto);
	public Insurance updateInsurance(long idEmployee, InsuranceDto insuranceDto);
	public String deleteInsurance(long idInsurance);
	public Insurance getById(long id);
	public Insurance getByEmployee(long idEmployee);
	public List<Insurance> getByCategoryContaining(String category);
	public List<Insurance> getByStartAt(Date date);
	public List<Insurance> getByExpirationAt(Date date);
	public List<Insurance> getByAddressReigisterContaining(String addressRegister);
}
