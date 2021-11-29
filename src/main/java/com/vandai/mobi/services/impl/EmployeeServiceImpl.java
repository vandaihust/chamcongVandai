package com.vandai.mobi.services.impl;

import java.util.List;

import org.springframework.data.domain.Page;

import com.vandai.mobi.dto.EmployeeDto;
import com.vandai.mobi.model.Employee;
import com.vandai.mobi.model.TimeKeeping;

public interface EmployeeServiceImpl {
	public List<Employee> getAllEmployees();
	public boolean deleteEmployeeById(long id);
	public Page<Employee> findPaginated(int pageNo, int pageSize, String sortField);
	public Employee addEmployee(EmployeeDto employeeDto);
	public Employee getEmployeeById(long id);      
	public boolean deleteEmployee(long id);    
	public boolean deleteEmployeeSelected(List<Long> id); 
	public boolean deleteAllEmployee(); 
	public String updateEmployee(EmployeeDto employee, long id); 
	public List<Employee> getEmployeeByName(String name);
	public List<Employee> getEmployeeByDepartment(Long idDepartment);
	
//	public List<Employee> getEmployeeByTimeKeeping(TimeKeeping timeKeeping);
//	public Employee addTimeKeeping(TimeKeeping timeKeeping, long id);
//	
}
