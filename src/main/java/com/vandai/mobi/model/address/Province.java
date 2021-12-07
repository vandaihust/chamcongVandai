package com.vandai.mobi.model.address;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Table(name = "province")
@Entity
@Getter
@Setter
public class Province {
	@Id
	private int id;
	@Column
	private String name;
	@Column
	private String code;
	@JsonIgnore
	@OneToMany(mappedBy = "province", cascade = CascadeType.ALL)
	private List<District> district = new ArrayList<District>(); 

	public void addDistrict(District districtElement) {
		this.district.add(districtElement);
	}
	@JsonIgnore
	@OneToMany(mappedBy = "province", cascade = CascadeType.ALL)
	private List<Ward> ward = new ArrayList<Ward>(); 

	public void addWard(Ward wardElement) {
		this.ward.add(wardElement);
	}
	@JsonIgnore
	@OneToMany(mappedBy = "province", cascade = CascadeType.ALL)
	private List<DetailAddress> detailaddress = new ArrayList<DetailAddress>(); 

	public void addDetailAddress(DetailAddress detailAddressElement) {
		this.detailaddress.add(detailAddressElement);
		
	}
}
