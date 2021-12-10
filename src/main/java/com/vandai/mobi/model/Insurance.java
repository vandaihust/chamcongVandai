package com.vandai.mobi.model;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.vandai.mobi.model.address.DetailAddress;

import lombok.Getter;
import lombok.Setter;

@Table(name = "insurance")
@Entity
@Getter
@Setter
public class Insurance {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column
	private String idInsurance;
	@Column
	private String category;
	@Column
	private Date startAt;//ngày cấp
	@Column
	private Date expirationAt;
	@Column
	private String addressReigister;
	
//	@OneToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "detailaddress_id")
//	private DetailAddress detailaddress;
	
	@OneToOne( fetch = FetchType.LAZY)
	@JsonIgnore
	@JoinColumn(name = "employee_id")
	private Employee employee;
}
