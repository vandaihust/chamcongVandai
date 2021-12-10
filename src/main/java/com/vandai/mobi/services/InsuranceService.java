package com.vandai.mobi.services;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vandai.mobi.dto.InsuranceDto;
import com.vandai.mobi.model.Employee;
import com.vandai.mobi.model.Insurance;
import com.vandai.mobi.model.address.DetailAddress;
import com.vandai.mobi.reponsitory.DetailAddressRepository;
import com.vandai.mobi.reponsitory.DistrictRepository;
import com.vandai.mobi.reponsitory.EmployeeRepository;
import com.vandai.mobi.reponsitory.InsuranceRepository;
import com.vandai.mobi.reponsitory.ProvinceRepository;
import com.vandai.mobi.reponsitory.WardRepository;
import com.vandai.mobi.services.impl.InsuranceServiceImpl;

@Service
public class InsuranceService implements InsuranceServiceImpl{
	@Autowired
	DetailAddressRepository detailAddressRepository; 
	@Autowired
	ProvinceRepository provinceRepository;
	@Autowired
	DistrictRepository districtRepository;
	@Autowired
	WardRepository wardRepository;
	@Autowired
	EmployeeRepository employeeRepository;
	@Autowired
	InsuranceRepository insuranceRepository;
	@Override
	public Insurance addInsurance(long idEmployee, InsuranceDto insuranceDto) {
		Employee e = employeeRepository.findById(idEmployee).get();
		try {
			if(e.getInsurance().getIdInsurance() != null) {
				return e.getInsurance();
			}
		} catch (Exception e2) {
			
		}
		
		Insurance insurance = new Insurance();
		insurance.setCategory(insuranceDto.getCategory());
		insurance.setExpirationAt(insuranceDto.getExpirationAt());
		insurance.setStartAt(insuranceDto.getStartAt());
		insurance.setIdInsurance(insuranceDto.getIdInsurance());
		insurance.setAddressReigister(insuranceDto.getAddressRegister());
		
//		DetailAddress detailAddress = new DetailAddress();
//		detailAddress.setProvince(provinceRepository.findById(insuranceDto.getIdProvince()).get());
//		detailAddress.setDistrict(districtRepository.findById(insuranceDto.getIdDistrict()).get());
//		detailAddress.setWard(wardRepository.findById(insuranceDto.getIdWard()).get());
//		insurance.setDetailaddress(detailAddress);
		insurance.setEmployee(e);
//		e.setInsurance(insurance);
//		employeeRepository.save(e);
//		detailAddressRepository.save(detailAddress);
		insuranceRepository.save(insurance);
		return insurance;
	}

	@Override
	public Insurance updateInsurance(long idEmployee, InsuranceDto insuranceDto) {
		Employee e = employeeRepository.findById(idEmployee).get();
		Insurance insurance = new Insurance();
		
		insurance.setId(e.getInsurance().getId());
		insurance.setAddressReigister(insuranceDto.getAddressRegister());
		insurance.setCategory(insuranceDto.getCategory());
		insurance.setExpirationAt(insuranceDto.getExpirationAt());
		insurance.setStartAt(insuranceDto.getStartAt());
		insurance.setIdInsurance(insuranceDto.getIdInsurance());
		
//		DetailAddress detailAddress = new DetailAddress();
//		detailAddress.setProvince(provinceRepository.findById(insuranceDto.getIdProvince()).get());
//		detailAddress.setDistrict(districtRepository.findById(insuranceDto.getIdDistrict()).get());
//		detailAddress.setWard(wardRepository.findById(insuranceDto.getIdWard()).get());
//		insurance.setDetailaddress(detailAddress);
		insurance.setEmployee(e);
		insuranceRepository.save(insurance);
		return insurance;
	}

	@Override
	public String deleteInsurance(long idInsurance) {
		if(insuranceRepository.existsById(idInsurance)) {
			insuranceRepository.deleteById(idInsurance);
			return "Delete insurance successfully";
		}
		return "Delete insurance fail";
	}

	@Override
	public Insurance getById(long id) {
		return insuranceRepository.findById(id).get();
	}

	@Override
	public Insurance getByEmployee(long idEmployee) {
		return insuranceRepository.findByEmployee(employeeRepository.findById(idEmployee).get());
	}

	@Override
	public List<Insurance> getByCategoryContaining(String category) {
		List<Insurance> insurances = insuranceRepository.findByCategoryContaining(category);
		return insurances;
	}

	@Override
	public List<Insurance> getByStartAt(Date date) {
		return insuranceRepository.findByStartAt(date);
	}

	@Override
	public List<Insurance> getByExpirationAt(Date date) {
		return insuranceRepository.findByExpirationAt(date);
	}

	@Override
	public List<Insurance> getByAddressReigisterContaining(String addressRegister) {
		return insuranceRepository.findByAddressReigisterContaining(addressRegister);
	}

}
