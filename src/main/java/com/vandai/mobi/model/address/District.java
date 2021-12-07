package com.vandai.mobi.model.address;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Table(name = "district")
@Entity
@Getter
@Setter
public class District {
	@Id
	private int id;
	@Column
	private String name;
	@Column
	private String prefix;
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "province_id")
	private Province province;
	@JsonIgnore
	@OneToMany(mappedBy = "district", cascade = CascadeType.ALL)
	private List<Ward> ward = new ArrayList<Ward>(); 

	public void addWard(Ward wardElement) {
		this.ward.add(wardElement);
	}
	@JsonIgnore
	@OneToMany(mappedBy = "district", cascade = CascadeType.ALL)
	private List<DetailAddress> detailaddress = new ArrayList<DetailAddress>(); 

	public void addDetailAddress(DetailAddress detailAddressElement) {
		this.detailaddress.add(detailAddressElement);
	}
	
}
