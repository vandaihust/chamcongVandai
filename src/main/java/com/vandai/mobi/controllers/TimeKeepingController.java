package com.vandai.mobi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.vandai.mobi.model.StatusDay;
import com.vandai.mobi.services.EmployeeService;
import com.vandai.mobi.services.StatusDayService;
import com.vandai.mobi.services.TimeKeepingService;

@RestController
@CrossOrigin("*")
@RequestMapping("api/timekeeping")
public class TimeKeepingController {
	@Autowired
	EmployeeService employeeService;
	@Autowired
	TimeKeepingService timeKeepingService;
	@Autowired
	StatusDayService statusDayService;
	@PostMapping("/checkin/{id}")
	@PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
	public ResponseEntity<?> checkIn(@PathVariable long id){
		StatusDay statusDay = statusDayService.checkIn(id);	
		return new ResponseEntity<>(statusDay, HttpStatus.OK);
	}
	@PostMapping("/checkout/{id}")
	@PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
	public ResponseEntity<?> checkOut(@PathVariable long id){
		StatusDay statusDay = statusDayService.checkOut(id);	
		return new ResponseEntity<>(statusDay, HttpStatus.OK);
	}
	
	
}
