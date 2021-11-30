package com.vandai.mobi.model;


import java.sql.Date;
import java.sql.Time;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "status_day")
@Getter
@Setter
public class StatusDay {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@Column
	@CreationTimestamp
	private Date startAt;
	@Column
	private boolean status;
	@Column
	private Time inAt;
	@Column
	private int inStatus;
	@Column
	private Time outAt;
	@Column
	private int outStatus;
	@Column
	private int shift;
	@ManyToOne
	@JoinColumn(name = "timeKeeping_id")
	private TimeKeeping timeKeeping;

}
