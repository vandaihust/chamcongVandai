package com.vandai.mobi.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Table(name = "employee")
@Data
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column
	private String idEmployee;
	@Column
	private String name;
	@Column
	private boolean sex;
	@Column
	private String birthDate;
	@Column
	private String idCardNumber;
	@Column
	private String phone;
	@Column
	private String academicLevel;
	@Column
	private String email;
	@Column
	private String maritalStatus;
	@Column
	private String avatar;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id")
	private User user;

	@ManyToOne(targetEntity = Department.class)
	@JsonIgnore
	@JoinColumn(name = "department_id")//not null
	private Department department;
	
	
}
