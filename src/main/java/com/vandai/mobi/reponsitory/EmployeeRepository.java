package com.vandai.mobi.reponsitory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vandai.mobi.model.Department;
import com.vandai.mobi.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{
	public List<Employee> findByName(String name);
//	public List<Employee> findByDepartment(Department department);
}
