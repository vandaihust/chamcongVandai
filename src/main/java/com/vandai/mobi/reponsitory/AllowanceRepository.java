package com.vandai.mobi.reponsitory;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vandai.mobi.model.Allowance;
import com.vandai.mobi.model.Employee;

@Repository
public interface AllowanceRepository extends JpaRepository<Allowance, Integer>{
	public Allowance findByIdAllowance(String idAllowance);
	public List<Allowance> findByStartAt(Date startAt);
	public List<Allowance> findByEndAt(Date endAt);
	public List<Allowance> findByEmployee(Employee employee);
}
