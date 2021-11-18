package com.vandai.mobi.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "department")
@Data
public class Department {
	@Id
	private String id;
	@Column
	private String name;
	@OneToMany(mappedBy = "department")
	private Set<Employee> employees = new HashSet<Employee>();
}
