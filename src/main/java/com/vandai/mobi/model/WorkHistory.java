package com.vandai.mobi.model;

import java.sql.Date;

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

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Table(name = "work_history")
@Entity
@Getter
@Setter
public class WorkHistory {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(nullable = false, updatable = false)
	@CreationTimestamp
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date startAt;
	@Column
	@UpdateTimestamp
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date endAt;
	@Column
	private String reason;
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "position_id")
	private Position position;
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "employee_id")
	private Employee employee;
}
