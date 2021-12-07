package com.vandai.mobi.reponsitory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vandai.mobi.model.address.Province;

public interface ProvinceRepository extends JpaRepository<Province, Integer>{
	public List<Province> findByNameContaining(String name);
}
