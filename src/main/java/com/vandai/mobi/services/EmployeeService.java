package com.vandai.mobi.services;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.vandai.mobi.dto.EmployeeDto;
import com.vandai.mobi.model.Department;
import com.vandai.mobi.model.Employee;
import com.vandai.mobi.model.User;
import com.vandai.mobi.reponsitory.DepartmentRepository;
import com.vandai.mobi.reponsitory.EmployeeRepository;
import com.vandai.mobi.reponsitory.UserRepository;
import com.vandai.mobi.services.impl.EmployeeServiceImpl;
@Service
public class EmployeeService implements EmployeeServiceImpl{
	@Autowired
	EmployeeRepository employeeRepository;
	@Autowired
	DepartmentRepository departmentRepository;
	@Autowired
	UserRepository userRepository; 
	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> listEmployee = employeeRepository.findAll();
		return listEmployee;
	}

	@Override
	public boolean deleteEmployeeById(long id) {
		employeeRepository.deleteById(id);
		return true;	
	}

	@Override
	public Page<Employee> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
		Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
			Sort.by(sortField).descending();
		
		Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
		return employeeRepository.findAll(pageable);
	}

	@Override
	public Employee addEmployee(EmployeeDto employeeDto) {
		Employee employee = new Employee();
		Optional<User> user = userRepository.findById(employeeDto.getIdUser());
		Department department = departmentRepository.getById(employeeDto.getIdDepartment());
		employee.setIdEmployee(employeeDto.getIdEmployee());
		employee.setName(employeeDto.getName());
		employee.setSex(false);
		employee.setBirthDate(employeeDto.getBirthDate());
		employee.setIdCardNumber(employeeDto.getIdCardNumber());
		employee.setPhone(employeeDto.getPhone());
		employee.setEmail(employeeDto.getEmail());
		employee.setMaritalStatus(employeeDto.getMaritalStatus());
		employee.setAvatar(employeeDto.getAvatar());
		employee.setAcademicLevel(employeeDto.getAcademicLevel());
		employee.setDepartment(department);
		employee.setUser(user.get());
		departmentRepository.save(department);
		System.out.println(department);
		System.out.println(employee);
		System.out.println(user);
		employeeRepository.save(employee);
		return employee;
	}

	@Override
	public Optional<Employee> getEmployeeById(long id) {
		Optional<Employee> e = employeeRepository.findById(id);
		return e;
	}

	@Override
	public boolean deleteEmployee(long id) {
		employeeRepository.deleteById(id);
		return true;
	}

	@Override
	public boolean deleteEmployeeSelected(List<Long> id) {
		for (long idStr : id) {
			if(employeeRepository.existsById(idStr) == true) {
				employeeRepository.deleteById(idStr);
			}
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteAllEmployee() {
		employeeRepository.deleteAll();
		return true;
	}

	@Override
	public boolean updateEmployee(Employee employee, long id) {
		Employee e = employeeRepository.getById(id);
		if(e.getIdEmployee().equals(employee.getIdEmployee())) {
			employeeRepository.save(employee);
			return true;
		}
		return false;
	}

	@Override
	public List<Employee> getEmployeeByName(String name) {
		List<Employee> listEmployee = employeeRepository.findByName(name);
		return listEmployee;
	}


//	@Override
//	public List<Employee> getEmployeeByDepartment(Department department) {
//		List<Employee> listEmployee = employeeRepository.findByDepartment(department);
//		return listEmployee;
//	}


}
