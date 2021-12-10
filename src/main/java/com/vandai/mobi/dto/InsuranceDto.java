package com.vandai.mobi.dto;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class InsuranceDto {
	
	private String idInsurance;
	private String category;
	private Date startAt;//ngày cấp
	private Date expirationAt;
	private String addressRegister;
	
}
