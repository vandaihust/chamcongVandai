package com.vandai.mobi.services;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vandai.mobi.model.Allowance;
import com.vandai.mobi.reponsitory.AllowanceRepository;
import com.vandai.mobi.reponsitory.CategoryAllowanceRepository;
import com.vandai.mobi.reponsitory.EmployeeRepository;
import com.vandai.mobi.services.impl.AllowanceServiceImpl;

@Service
public class AllowanceService implements AllowanceServiceImpl{
	@Autowired
	EmployeeRepository employeeRepository;
	@Autowired
	AllowanceRepository allowanceRepository;
	@Autowired
	CategoryAllowanceRepository categoryAllowanceRepository;
	@Override
	public Allowance addAllowance(Allowance allowance, long idEmployee) {
		allowance.setEmployee(employeeRepository.findById(idEmployee).get());
		allowanceRepository.save(allowance);
		return allowance;
	}

	@Override
	public List<Allowance> getAllAllowance() {
		return allowanceRepository.findAll();
	}

	@Override
	public Allowance updateAllowance(Allowance allowance, int idAllowance, long idEmployee) {
		allowance.setId(idAllowance);
		allowance.setEmployee(employeeRepository.findById(idEmployee).get());
		allowanceRepository.save(allowance);
		return allowance;
	}

	@Override
	public String deleteAllowance(int id) {
		if(allowanceRepository.existsById(id)) {
			allowanceRepository.deleteById(id); 
			return "Delete allowance successfully";
		}
		return "Delete allowance fail";
	}

	@Override
	public Allowance getAllowanceById(int id) {
		return allowanceRepository.findById(id).get();
	}

	@Override
	public Allowance getAllowanceByIdAllowance(String idAllowance) {
		return allowanceRepository.findByIdAllowance(idAllowance);
	}

	@Override
	public List<Allowance> getAllowanceStartAt(Date startAt) {
		return allowanceRepository.findByStartAt(startAt);
	}

	@Override
	public List<Allowance> getAllowanceEndAt(Date endAt) {
		return allowanceRepository.findByEndAt(endAt);
	}

	@Override
	public List<Allowance> getAllowanceEmployee(long id) {
		return allowanceRepository.findByEmployee(employeeRepository.findById(id).get());
	}

	@Override
	public List<Allowance> fakeDataAllowance() {
		// TODO Auto-generated method stub
		return null;
	}

}
