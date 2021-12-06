package com.vandai.mobi.controllers;

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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.vandai.mobi.model.StatusDay;
import com.vandai.mobi.model.TimeKeeping;
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
	
	@GetMapping("employee/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> getTimeKeepingByIdEmployee(@PathVariable int id){
		List<TimeKeeping> timeKeepings = timeKeepingService.getTimeKeepingEmployee(id);	
		return new ResponseEntity<>(timeKeepings, HttpStatus.OK);
	}
	@GetMapping
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> getAllTimeKeeping(){
		List<TimeKeeping> timeKeepings = timeKeepingService.getAllTimeKeeping();	
		return new ResponseEntity<>(timeKeepings, HttpStatus.OK);
	}
	@GetMapping("/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> getTimeKeepingById(@PathVariable int id){
		TimeKeeping timeKeepings = timeKeepingService.getTimeKeepingById(id);	
		return new ResponseEntity<>(timeKeepings, HttpStatus.OK);
	}
	@DeleteMapping("/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> deleteTimeKeepingById(@PathVariable int id){
		String meg = timeKeepingService.deleteTimeKeeping(id);	
		return new ResponseEntity<>(meg, HttpStatus.OK);
	}
	@PostMapping("/{idEmployee}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> addTimeKeeping(@RequestBody TimeKeeping timeKeeping, @PathVariable long idEmployee){
		TimeKeeping timeKeeping2 = timeKeepingService.addTimeKeeping(timeKeeping, idEmployee);	
		
		return new ResponseEntity<>(timeKeeping2, HttpStatus.OK);
	}
	//compute hour of work in timekeeping
	@GetMapping("/caculate")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> caculateHour(){
		List<TimeKeeping> listTimeKeepings = timeKeepingService.getAllTimeKeeping();
		for (TimeKeeping timeKeeping : listTimeKeepings) {
			List<StatusDay> statusDays = statusDayService.getStatusDayByTimeKeeping(timeKeeping.getId());
			long time = 0;
			for (StatusDay statusDay : statusDays) {
				long c = statusDay.getOutAt().getTime() - statusDay.getInAt().getTime();
				time += c;
			}
			time = time /1000;
			timeKeeping.setHour(time);//đơn vị giây
			
			if(time>0) timeKeeping.setStatusOfDay(1);//đi làm
			else if (time == 0) timeKeeping.setStatusOfDay(0);//vắng
			
			timeKeepingService.updateTimeKeeping(timeKeeping, timeKeeping.getId());
		}
		
		return new ResponseEntity<>(listTimeKeepings, HttpStatus.OK);
	}
	
}
