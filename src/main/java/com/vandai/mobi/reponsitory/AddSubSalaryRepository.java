package com.vandai.mobi.reponsitory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vandai.mobi.model.AddSubSalary;
import com.vandai.mobi.model.Employee;

@Repository
public interface AddSubSalaryRepository extends JpaRepository<AddSubSalary, Long>{
	public List<AddSubSalary> findByEmployee(Employee employee);
	public List<AddSubSalary> findByCategory(int category);
}
