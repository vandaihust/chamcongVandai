package com.vandai.mobi.services.impl;

import java.sql.Date;
import java.util.List;

import com.vandai.mobi.model.Allowance;

public interface AllowanceServiceImpl {
	public Allowance addAllowance(Allowance allowance, long idEmployee);
	public List<Allowance> getAllAllowance();
	public Allowance updateAllowance(Allowance allowance, int idAllowance, long idEmployee);
	public String deleteAllowance(int id);
	public Allowance getAllowanceById(int id);
	public Allowance getAllowanceByIdAllowance(String idAllowance);
	public List<Allowance> getAllowanceStartAt(Date startAt);
	public List<Allowance> getAllowanceEndAt(Date endAt);
	public List<Allowance> getAllowanceEmployee(long id);
	public List<Allowance> fakeDataAllowance();
}
