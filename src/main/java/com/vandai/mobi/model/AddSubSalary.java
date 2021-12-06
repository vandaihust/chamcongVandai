package com.vandai.mobi.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "addsub_salary")
@Getter
@Setter
public class AddSubSalary {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column
	private int category;
	@Column
	private long salary;
	@Column
	private String reason;
	@Column(nullable = false, updatable = false)
	@CreationTimestamp
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date dateCreate;
	@Column
	@UpdateTimestamp
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date dateUpdate;
	
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "employee_id")
	private Employee employee;
}
