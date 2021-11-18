package com.vandai.mobi.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "employee")
@Data
public class Employee {
	@Id
	private String id;
	@Column
	private String name;
	@Column
	private boolean sex;
	@Column
	private Date birthDate;
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

	@ManyToOne
	@JoinColumn(name = "department_id", nullable = false)//not null
	private Department department;
}
