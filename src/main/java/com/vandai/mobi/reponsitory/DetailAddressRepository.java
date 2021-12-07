package com.vandai.mobi.reponsitory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vandai.mobi.model.Employee;
import com.vandai.mobi.model.address.DetailAddress;
import com.vandai.mobi.model.address.District;
import com.vandai.mobi.model.address.Province;
import com.vandai.mobi.model.address.Ward;
@Repository
public interface DetailAddressRepository extends JpaRepository<DetailAddress, Integer> {
	public List<DetailAddress> findByProvince(Province province);
	public List<DetailAddress> findByDistrict(District district);
	public List<DetailAddress> findByWard(Ward ward);
	public DetailAddress findByEmployee(Employee employee);
	public List<DetailAddress> findByNameContaining(String name);
}
