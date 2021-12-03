package com.vandai.mobi.model;

import java.sql.Date;
import java.sql.Time;
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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "time_keeping")
@Getter
@Setter
public class TimeKeeping {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@Column
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date date;
	@Column
	private int statusOfDay;
	@Column
	private long hour;
	@JsonIgnore
	@OneToMany(mappedBy = "timeKeeping", cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private List<StatusDay> statusDays = new ArrayList<StatusDay>();	
	public void addStatusDay(StatusDay statusDay) {
		this.statusDays.add(statusDay);
	}
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "employee_id")
	private Employee employee;
		
}
