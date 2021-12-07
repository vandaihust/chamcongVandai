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

@Table(name = "ward")
@Entity
@Getter
@Setter
public class Ward {
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
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "district_id")
	private District district;
	@JsonIgnore
	@OneToMany(mappedBy = "ward", cascade = CascadeType.ALL)
	private List<DetailAddress> detailaddress = new ArrayList<DetailAddress>(); 

	public void addDetailAddress(DetailAddress detailAddressElement) {
		this.detailaddress.add(detailAddressElement);
	}
}
