package com.vandai.mobi.services.impl;

import java.util.List;

import com.vandai.mobi.model.address.District;
import com.vandai.mobi.model.address.Province;
import com.vandai.mobi.model.address.Ward;

public interface AddressServiceImpl {
	public List<Province> searchProvince(String name);
	public List<District> searchDistrict(int idProvince, String name);
	public List<Ward> searchWard(int idProvince, int idDistrict, String name);
}
