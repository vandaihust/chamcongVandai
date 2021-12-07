package com.vandai.mobi.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.vandai.mobi.dto.EmployeeDto;
import com.vandai.mobi.model.Department;
import com.vandai.mobi.model.Employee;
import com.vandai.mobi.model.Position;
import com.vandai.mobi.model.Salary;
import com.vandai.mobi.model.TimeKeeping;
import com.vandai.mobi.model.User;
import com.vandai.mobi.model.WorkHistory;
import com.vandai.mobi.model.address.DetailAddress;
import com.vandai.mobi.model.address.District;
import com.vandai.mobi.reponsitory.DepartmentRepository;
import com.vandai.mobi.reponsitory.DetailAddressRepository;
import com.vandai.mobi.reponsitory.DistrictRepository;
import com.vandai.mobi.reponsitory.EmployeeRepository;
import com.vandai.mobi.reponsitory.PositionRepository;
import com.vandai.mobi.reponsitory.ProvinceRepository;
import com.vandai.mobi.reponsitory.SalaryRepository;
import com.vandai.mobi.reponsitory.UserRepository;
import com.vandai.mobi.reponsitory.WardRepository;
import com.vandai.mobi.reponsitory.WorkHistoryRepository;
import com.vandai.mobi.services.impl.EmployeeServiceImpl;
@Service
public class EmployeeService implements EmployeeServiceImpl{
	@Autowired
	EmployeeRepository employeeRepository;
	@Autowired
	DepartmentRepository departmentRepository;
	@Autowired
	UserRepository userRepository; 
	@Autowired
	PositionRepository positionRepository;
	@Autowired
	SalaryRepository salaryRepository;
	@Autowired
	WorkHistoryRepository workHistoryRepository;
	@Autowired
	DetailAddressRepository detailAddressRepository; 
	@Autowired
	ProvinceRepository provinceRepository;
	@Autowired
	DistrictRepository districtRepository;
	@Autowired
	WardRepository wardRepository;
	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> listEmployee = employeeRepository.findAll(Sort.by(Sort.Direction.ASC, "name"));
		return listEmployee;
	}

	@Override
	public boolean deleteEmployeeById(long id) {
		employeeRepository.deleteById(id);
		return true;	
	}

	@Override
	public Page<Employee> findPaginated(int pageNo, int pageSize, String sortField) {
		
		Sort sort = Sort.by(sortField).ascending() ;
			
		//
		Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
		return employeeRepository.findAll(pageable);
		
		//ASC: A->Z
	}

	@Override
	public Employee addEmployee(EmployeeDto employeeDto) {
		Employee employee = new Employee();
		User user = userRepository.findById(employeeDto.getIdUser()).get();
		Department department = departmentRepository.findById(employeeDto.getIdDepartment()).get();
		Position position = positionRepository.findById(employeeDto.getIdPosition()).get();
		Salary salary = salaryRepository.findById(employeeDto.getCoefficientsSalary()).get();
		employee.setIdEmployee(employeeDto.getIdEmployee());
		employee.setName(employeeDto.getName());
		employee.setSex(employeeDto.isSex());
		employee.setBirthDate(employeeDto.getBirthDate());
		employee.setIdCardNumber(employeeDto.getIdCardNumber());
		employee.setPhone(employeeDto.getPhone());
		employee.setEmail(employeeDto.getEmail());
		employee.setMaritalStatus(employeeDto.getMaritalStatus());
		employee.setAvatar(employeeDto.getAvatar());
		employee.setAcademicLevel(employeeDto.getAcademicLevel());		
		employee.setUser(user);	
		employee.setDepartment(department);		
		employee.setPosition(position);
		employee.setSalary(salary);
		//detail address
		DetailAddress detailAddress = new DetailAddress();
		detailAddress.setName(employeeDto.getNameAddress());
		detailAddress.setProvince(provinceRepository.findById(employeeDto.getIdProvince()).get());
		detailAddress.setDistrict(districtRepository.findById(employeeDto.getIdDistrict()).get());
		detailAddress.setWard(wardRepository.findById(employeeDto.getIdWard()).get());
		employee.setDetailaddress(detailAddress);
		//
		salary.addEmployee(employee);
		salaryRepository.save(salary);
		position.addEmployee(employee);
		positionRepository.save(position);
		department.addEmployee(employee);
		departmentRepository.save(department);	//CascadeType.ALL nên ko cần save E
		//work History create
		WorkHistory workHistory = new WorkHistory();
		workHistory.setEmployee(employee);
		workHistory.setPosition(position);
		workHistory.setEndAt(null);
		workHistoryRepository.save(workHistory);
		//
		return employee;
	
	}

	@Override
	public Employee getEmployeeById(long id) {
		Employee e = employeeRepository.findById(id).get();
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
	public String updateEmployee(EmployeeDto employeeDto, long id) {
		Employee employee = new Employee();
		int idOldPosition = employeeRepository.findById(id).get().getPosition().getId();
		User user = userRepository.findById(employeeDto.getIdUser()).get();
		Department department = departmentRepository.findById(employeeDto.getIdDepartment()).get();
		Position position = positionRepository.findById(employeeDto.getIdPosition()).get();
		Salary salary = salaryRepository.findById(employeeDto.getCoefficientsSalary()).get();
		
		employee.setId(id);
		employee.setIdEmployee(employeeDto.getIdEmployee());
		employee.setName(employeeDto.getName());
		employee.setSex(employeeDto.isSex());
		employee.setBirthDate(employeeDto.getBirthDate());
		employee.setIdCardNumber(employeeDto.getIdCardNumber());
		employee.setPhone(employeeDto.getPhone());
		employee.setEmail(employeeDto.getEmail());
		employee.setMaritalStatus(employeeDto.getMaritalStatus());
		employee.setAvatar(employeeDto.getAvatar());
		employee.setAcademicLevel(employeeDto.getAcademicLevel());		
		employee.setUser(user);	
		employee.setDepartment(department);		
		employee.setPosition(position);
		employee.setSalary(salary);
		//update detail address
		DetailAddress detailAddress = new DetailAddress();
		detailAddress.setName(employeeDto.getNameAddress());
		detailAddress.setProvince(provinceRepository.findById(employeeDto.getIdProvince()).get());
		detailAddress.setDistrict(districtRepository.findById(employeeDto.getIdDistrict()).get());
		detailAddress.setWard(wardRepository.findById(employeeDto.getIdWard()).get());
		employee.setDetailaddress(detailAddress);
		//
		
		employeeRepository.save(employee);
		
		if(employeeRepository.save(employee) != null) {
			//update endAt WorkHistory
			List<WorkHistory> histories = workHistoryRepository.findByEmployee(employee);
			WorkHistory workHistory = histories.get(histories.size() - 1);
			System.out.println(histories.get(histories.size() - 1).getStartAt());
			System.out.println(employeeDto.getIdPosition()!= idOldPosition);
			if(employeeDto.getIdPosition()!= idOldPosition) {
				if(workHistory.getReason() == null ) {
					workHistory.setEmployee(employee);
					workHistory.setPosition(position);
					workHistory.setReason(employeeDto.getReason());
					workHistoryRepository.save(workHistory);
				} else {
					WorkHistory workHistory2 = new WorkHistory();
					workHistory2.setEmployee(employee);
					workHistory2.setPosition(position);
					workHistoryRepository.save(workHistory2);
				}
			}
			//
			return "Update Success";
		}
		return "Update fail";
	
	}

	@Override
	public List<Employee> getEmployeeByName(String name) {
//		Sort sort =  Sort.by("name").descending();//Z-->A
		Sort sort =  Sort.by("name").ascending();
		List<Employee> listEmployee = employeeRepository.findByNameIsContaining(name, sort);
		System.out.println(Sort.Direction.ASC.name());
		return listEmployee;
	}


	@Override
	public List<Employee> getEmployeeByDepartment(Long idDepartment) {
		Department department = departmentRepository.findById(idDepartment).get();
		List<Employee> listEmployee = employeeRepository.findByDepartment(department);
		return listEmployee;
	}
//search address
	
	
	@Override
	public List<Employee> searchEmployeeByAddress(int idProvince) {
		List<DetailAddress> addresses = provinceRepository.findById(idProvince).get().getDetailaddress();
		List<Employee> employees = new ArrayList<Employee>();
		for (DetailAddress detailAddress : addresses) {
			employees.addAll(employeeRepository.findBydetailaddress(detailAddress));
		}
		return employees;
	}

	@Override
	public List<Employee> searchEmployeeByAddress(int idProvince, int idDistrict) {
		List<DetailAddress> addresses = districtRepository.findById(idDistrict).get().getDetailaddress();
		List<Employee> employees = new ArrayList<Employee>();
		for (DetailAddress detailAddress : addresses) {
			employees.addAll(employeeRepository.findBydetailaddress(detailAddress));
		}
		return employees;
	}

	@Override
	public List<Employee> searchEmployeeByAddress(int idProvince, int idDistrict, int idWard) {
		List<DetailAddress> addresses = wardRepository.findById(idWard).get().getDetailaddress();
		List<Employee> employees = new ArrayList<Employee>();
		for (DetailAddress detailAddress : addresses) {
			employees.addAll(employeeRepository.findBydetailaddress(detailAddress));
		}
		return employees;
	}

	@Override
	public List<Employee> searchEmployeeByAddress(int idProvince, int idDistrict, int idWard, String nameAddress) {
		// TODO Auto-generated method stub
		return null;
	}

//	@Override
//	public List<Employee> getEmployeeByTimeKeeping(TimeKeeping timeKeeping) {
//		List<Employee> list = employeeRepository.findByTimeKeeping(timeKeeping);
//		return list;
//	}
//
//	@Override
//	public Employee addTimeKeeping(TimeKeeping timeKeeping, long id) {
//		Employee em = employeeRepository.findById(id).get();
//		return em;
//	}
	
	


}
