package com.vandai.mobi.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;

@Table(name = "reader")
@Entity
@Getter
@Setter
public class Reader {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column
	private String idReader;
	@Column
	private String name;
	@Column
	private String address;
	@Column
	private int status;
	@Column
	private Date dateBuy;
	@Column
	private String addressSupply;
	@Column
	private String image;
	@Column
	private String departmentUse;
}
