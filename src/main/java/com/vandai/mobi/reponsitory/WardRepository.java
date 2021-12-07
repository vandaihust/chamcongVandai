package com.vandai.mobi.reponsitory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vandai.mobi.model.address.District;
import com.vandai.mobi.model.address.Province;
import com.vandai.mobi.model.address.Ward;

@Repository
public interface WardRepository extends JpaRepository<Ward, Integer>{
	public List<Ward> findByDistrict(District district);
	public List<Ward> findByProvince(Province province);
	public List<Ward> findByNameContaining(String name);
}
