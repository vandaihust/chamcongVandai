package com.vandai.mobi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.vandai.mobi.model.Employee;
import com.vandai.mobi.model.address.DetailAddress;
import com.vandai.mobi.model.address.District;
import com.vandai.mobi.model.address.Province;
import com.vandai.mobi.model.address.Ward;
import com.vandai.mobi.reponsitory.DetailAddressRepository;
import com.vandai.mobi.reponsitory.EmployeeRepository;
import com.vandai.mobi.services.impl.DetailAddressServiceImpl;

public class DetailAddressService implements DetailAddressServiceImpl{
	@Autowired
	DetailAddressRepository detailAddressRepository;
	@Autowired
	EmployeeRepository employeeRepository;
	@Override
	public DetailAddress addDetailAddress(long idEmployee, DetailAddress detailAddress) {
		Employee e = employeeRepository.findById(idEmployee).get();
		e.setDetailaddress(detailAddress);
		employeeRepository.save(e);
		return detailAddress;
	}

	@Override
	public DetailAddress updateDetailAddress(long idEmployee, int idDetailAddress, DetailAddress detailAddress) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteDetailAddress(int idDetailAddress) {
		if(detailAddressRepository.existsById(idDetailAddress)) {
			detailAddressRepository.deleteById(idDetailAddress);
			return "Delete DetailAddress Successfully";
		}
		return "Delete DetailAddress fail";
	}

	@Override
	public List<DetailAddress> getByProvince(Province province) {
		List<DetailAddress> detailAddresses = detailAddressRepository.findByProvince(province);
		return detailAddresses;
	}

	@Override
	public List<DetailAddress> getByDistrict(District district) {
		List<DetailAddress> detailAddresses = detailAddressRepository.findByDistrict(district);
		return detailAddresses;
	}

	@Override
	public List<DetailAddress> getByWard(Ward ward) {
		List<DetailAddress> detailAddresses = detailAddressRepository.findByWard(ward);
		return detailAddresses;
	}

	@Override
	public List<DetailAddress> getByName(String name) {
		List<DetailAddress> addresses = detailAddressRepository.findByNameContaining(name);
		return addresses;
	}

	@Override
	public DetailAddress getDetailAddressById(int id) {
		return detailAddressRepository.findById(id).get();
	}

}
