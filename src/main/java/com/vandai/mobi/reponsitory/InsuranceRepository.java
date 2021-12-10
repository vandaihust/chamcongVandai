package com.vandai.mobi.reponsitory;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vandai.mobi.model.Employee;
import com.vandai.mobi.model.Insurance;
@Repository
public interface InsuranceRepository extends JpaRepository<Insurance, Long> {
	public Insurance findByEmployee(Employee employee);
	public List<Insurance> findByCategoryContaining(String category);
	public List<Insurance> findByStartAt(Date date);
	public List<Insurance> findByExpirationAt(Date date);
	public List<Insurance> findByAddressReigisterContaining(String addressRegister);
	
}
