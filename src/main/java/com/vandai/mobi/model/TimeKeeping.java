package com.vandai.mobi.model;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	private boolean statusOfDay;
	@Column
	private Long hour;
	@JsonIgnore
	@OneToMany(mappedBy = "timeKeeping", cascade = CascadeType.ALL)
	private Set<StatusDay> statusDays = new HashSet<StatusDay>();	
	public void addStatusDay(StatusDay statusDay) {
		this.statusDays.add(statusDay);
	}
	
}
