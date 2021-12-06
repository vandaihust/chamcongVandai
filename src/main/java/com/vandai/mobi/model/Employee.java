package com.vandai.mobi.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "employee")
@Getter
@Setter
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
	
	@ManyToOne
	@JoinColumn(name = "department_id")
	private Department department;
	
	@ManyToOne
	@JoinColumn(name = "position_id")
	private Position position;
	
	@ManyToOne
	@JoinColumn(name = "coefficients_salary_id")
	private Salary salary;
	
	@JsonIgnore
	@OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
	private List<TimeKeeping> timeKeeping = new ArrayList<TimeKeeping>(); 

	public void addTimeKeeping(TimeKeeping timeKeeping) {
		this.timeKeeping.add(timeKeeping);
	}
	@JsonIgnore
	@OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
	private List<AddSubSalary> addsubSalary = new ArrayList<AddSubSalary>(); 

	public void addAddSubSalary(AddSubSalary addSubSalary) {
		this.addsubSalary.add(addSubSalary);
	}
	@JsonIgnore
	@OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
	private List<WorkHistory> workHistory = new ArrayList<WorkHistory>();

	public void addWorkHistory(WorkHistory workHistory2) {
		this.workHistory.add(workHistory2);
	}
}
