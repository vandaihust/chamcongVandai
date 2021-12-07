package com.vandai.mobi.services.impl;

import java.util.List;

import com.vandai.mobi.model.address.DetailAddress;
import com.vandai.mobi.model.address.District;
import com.vandai.mobi.model.address.Province;
import com.vandai.mobi.model.address.Ward;



public interface DetailAddressServiceImpl {
	public DetailAddress addDetailAddress(long idEmployee, DetailAddress detailAddress);
	public DetailAddress updateDetailAddress(long idEmployee, int idDetailAddress, DetailAddress detailAddress);
	public String deleteDetailAddress(int idDetailAddress);
	public List<DetailAddress> getByProvince(Province province);
	public List<DetailAddress> getByDistrict(District district);
	public List<DetailAddress> getByWard(Ward ward);
	public List<DetailAddress> getByName(String name);
	public DetailAddress getDetailAddressById(int id);
}
