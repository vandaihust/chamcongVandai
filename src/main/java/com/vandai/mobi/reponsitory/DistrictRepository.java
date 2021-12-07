package com.vandai.mobi.reponsitory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vandai.mobi.model.address.District;
import com.vandai.mobi.model.address.Province;
@Repository
public interface DistrictRepository extends JpaRepository<District, Integer>{
	public List<District> findByProvince(Province province);
	public List<District> findByNameContaining(String name);
}
