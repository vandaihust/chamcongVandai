package com.vandai.mobi.controllers;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vandai.mobi.model.StatusDay;
import com.vandai.mobi.services.EmployeeService;
import com.vandai.mobi.services.StatusDayService;
import com.vandai.mobi.services.TimeKeepingService;

@RestController
@CrossOrigin("*")
@RequestMapping("api/statusday")
public class StatusDayController {
	@Autowired
	EmployeeService employeeService;
	@Autowired
	TimeKeepingService timeKeepingService;
	@Autowired
	StatusDayService statusDayService;
	@GetMapping("{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> getStatusDayByTimeKeeping(@PathVariable int id){
		List<StatusDay> statusDays = statusDayService.getStatusDayByTimeKeeping(id);	
		return new ResponseEntity<>(statusDays, HttpStatus.OK);
	}
	//thêm statusday ở checkin và check out ở timeKeeping
	//bổ sung thêm khi check in check out không hoạt động
	@PostMapping("{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> addStatusDayInTimeKeeping(@PathVariable int id, @RequestBody StatusDay statusDay){
		StatusDay statusDays = statusDayService.addStatusDay(statusDay, id );	
		return new ResponseEntity<>(statusDays, HttpStatus.CREATED);
	}
	@PutMapping("{idStatusDay}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> updateStatusDay(@PathVariable int idStatusDay, @RequestBody StatusDay statusDay){
		StatusDay statusDays = statusDayService.updateStatusDay(statusDay, idStatusDay);	
		return new ResponseEntity<>(statusDays, HttpStatus.OK);
	}
	@DeleteMapping("{idStatusDay}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> deleteStatusDay(@PathVariable int idStatusDay){
		return new ResponseEntity<>(statusDayService.deleteStatusDay(idStatusDay), HttpStatus.OK);
	}
	@GetMapping("search/in/{instatus}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> getStatusDayByInStatus(@PathVariable int instatus){
		List<StatusDay> statusDays = statusDayService.getByInStatus(instatus);	
		return new ResponseEntity<>(statusDays, HttpStatus.OK);
	}
	@GetMapping("search/out/{outstatus}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> getStatusDayByOutStatus(@PathVariable int outstatus){
		List<StatusDay> statusDays = statusDayService.getByOutStatus(outstatus);	
		return new ResponseEntity<>(statusDays, HttpStatus.OK);
	}
//	@GetMapping("search/intat/{intat}")
//	@PreAuthorize("hasRole('ADMIN')")
//	public ResponseEntity<?> getStatusDayByInAt(@PathVariable Date intat){
//		List<StatusDay> statusDays = statusDayService.getByInAt(intat);	
//		return new ResponseEntity<>(statusDays, HttpStatus.OK);
//	}
//	@GetMapping("search/outat/{outat}")
//	@PreAuthorize("hasRole('ADMIN')")
//	public ResponseEntity<?> getStatusDayByOutAt(@PathVariable Date outat){
//		List<StatusDay> statusDays = statusDayService.getByOutAt(outat);	
//		return new ResponseEntity<>(statusDays, HttpStatus.OK);
//	}
}
