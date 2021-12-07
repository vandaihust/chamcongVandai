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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vandai.mobi.model.WorkHistory;
import com.vandai.mobi.services.WorkHistoryService;

@RestController
@CrossOrigin("*")
@RequestMapping("api/workhistory")
public class WorkHistoryController {
	@Autowired
	WorkHistoryService workHistoryService;
	@GetMapping("/employee/{idEmployee}")
	@PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
	public ResponseEntity<?> getWorkHistoryByEmployee(@PathVariable long idEmployee){
		List<WorkHistory> listWorkHistory = workHistoryService.getByEmployee(idEmployee);
		return new ResponseEntity<List<WorkHistory>>(listWorkHistory, HttpStatus.OK);
	}
	@GetMapping("/position/{idPosition}")
	@PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
	public ResponseEntity<?> getWorkHistoryByPosition(@PathVariable int idPosition){
		List<WorkHistory> listWorkHistory = workHistoryService.getByPosition(idPosition);
		return new ResponseEntity<List<WorkHistory>>(listWorkHistory, HttpStatus.OK);
	}
	@GetMapping("/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> getWorkHistoryById(@PathVariable long id){
		WorkHistory workHistory = workHistoryService.getById(id);		
		return new ResponseEntity<>(workHistory, HttpStatus.OK);
	}
	@PutMapping("/employee/{idEmployee}/position/{idPosition}/{idWorkHistory}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> updateWorkHistory(@RequestBody WorkHistory workHistory,@PathVariable long idEmployee,@PathVariable long idWorkHistory,@PathVariable int idPosition){
		return new ResponseEntity<>(workHistoryService.updateWorkHistory(idEmployee, idPosition, idWorkHistory, workHistory)
				, HttpStatus.OK);
	}
	@DeleteMapping("/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> deleteWorkHistory(@PathVariable long id){
		return new ResponseEntity<>(workHistoryService.deleteWorkHistory(id)
				, HttpStatus.OK);
	}
}
