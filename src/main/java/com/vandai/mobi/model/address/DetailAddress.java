package com.vandai.mobi.model.address;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.vandai.mobi.model.Employee;

import lombok.Getter;
import lombok.Setter;

@Table(name = "detailaddress")
@Entity
@Getter
@Setter
public class DetailAddress {
	@Id
	private int id;
	@Column
	private String name;
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "province_id")
	private Province province;
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "district_id")
	private District district;
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "ward_id")
	private Ward ward;
	@OneToOne(mappedBy = "detailaddress")
	@JsonIgnore
	private Employee employee;
}
