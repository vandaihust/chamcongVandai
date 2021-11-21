package com.vandai.mobi.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Table(name = "department")
@Data
public class Department {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column
	private String idDepartment;
	@Column
	private String name;
	
	@JsonIgnore
	@OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
	private Set<Employee> employees = new HashSet<Employee>();

	
	
}
