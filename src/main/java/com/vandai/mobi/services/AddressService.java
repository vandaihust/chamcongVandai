package com.vandai.mobi.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vandai.mobi.model.address.District;
import com.vandai.mobi.model.address.Province;
import com.vandai.mobi.model.address.Ward;
import com.vandai.mobi.reponsitory.DistrictRepository;
import com.vandai.mobi.reponsitory.ProvinceRepository;
import com.vandai.mobi.reponsitory.WardRepository;
import com.vandai.mobi.services.impl.AddressServiceImpl;

@Service
public class AddressService implements AddressServiceImpl{
	@Autowired
	ProvinceRepository provinceRepository;
	@Autowired
	DistrictRepository districtRepository;
	@Autowired
	WardRepository wardRepository;
	@Override
	public List<Province> searchProvince(String name) {
		List<Province> list = provinceRepository.findByNameContaining(name);
		return list;
	}

	@Override
	public List<District> searchDistrict(int idProvince, String name) {
		List<District> districts = new ArrayList<District>();
		List<District> districts2 = districtRepository.findByNameContaining(name);
		Province province = provinceRepository.findById(idProvince).get();
		for (District district : districts2) {
			if(district.getProvince().equals(province)) {
				districts.add(district);
			}
		}
		return districts;
	}

	@Override
	public List<Ward> searchWard(int idProvince, int idDistrict, String name) {
		Province province = provinceRepository.findById(idProvince).get();
		District district = districtRepository.findById(idDistrict).get();
		List<Ward> wards = new ArrayList<Ward>();
		List<Ward> wards2 = wardRepository.findByNameContaining(name);
		for (Ward ward : wards2) {
			if(ward.getDistrict().equals(district)) {
				wards.add(ward);
			}
		}
		return wards;
	}

}
