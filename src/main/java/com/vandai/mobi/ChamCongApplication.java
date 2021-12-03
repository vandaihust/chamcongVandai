package com.vandai.mobi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.vandai.mobi.services.RoleService;

@SpringBootApplication
@EnableScheduling
public class ChamCongApplication {
	@Autowired
	RoleService roleService;
	
	public static void main(String[] args) {
		SpringApplication.run(ChamCongApplication.class, args);
		
	}
	
}
