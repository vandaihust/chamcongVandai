package com.vandai.mobi.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "salary")
@Getter
@Setter
public class Salary {
	@Id
	private int coefficientsSalary;
	@Column
	private double basicSalary;
	@JsonIgnore
	@OneToMany(mappedBy = "salary", cascade = CascadeType.ALL)
	private Set<Employee> employees = new HashSet<Employee>(); 

	public void addEmployee(Employee e) {
		this.employees.add(e);
	}
}
