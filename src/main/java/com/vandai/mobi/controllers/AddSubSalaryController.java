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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vandai.mobi.model.AddSubSalary;
import com.vandai.mobi.services.AddSubSalaryService;

@RestController
@CrossOrigin("*")
@RequestMapping("api/addsubsalary")
public class AddSubSalaryController {
	@Autowired
	AddSubSalaryService addSubSalaryService;
	@GetMapping("/employee/{idEmployee}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> getAddSubSalaryByEmployee(@PathVariable long idEmployee){
		List<AddSubSalary> listAddSubSalary = addSubSalaryService.getByEmployee(idEmployee);
		return new ResponseEntity<List<AddSubSalary>>(listAddSubSalary, HttpStatus.OK);
	}
	@GetMapping("/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> getAddSubSalaryById(@PathVariable long id){
		AddSubSalary addSubSalary = addSubSalaryService.getAddSubSalaryById(id);		
		return new ResponseEntity<>(addSubSalary, HttpStatus.OK);
	}
	@PostMapping("{idEmployee}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> addAddSubSalary(@RequestBody AddSubSalary addSubSalary, @PathVariable long idEmployee){
		return new ResponseEntity<AddSubSalary>(addSubSalaryService.addAddSubSalary(idEmployee, addSubSalary)
				, HttpStatus.OK);
	}
	@PutMapping("/employee/{idEmployee}/{idAddSubSalary}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> updateAddSubSalary(@RequestBody AddSubSalary addSubSalary,@PathVariable long idEmployee,@PathVariable long idAddSubSalary){
		return new ResponseEntity<>(addSubSalaryService.updateAddSubSalary(idEmployee, idAddSubSalary, addSubSalary)
				, HttpStatus.OK);
	}
	@DeleteMapping("{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> deleteAddSubSalary(@PathVariable long id){
		return new ResponseEntity<>(addSubSalaryService.deleteAddSubSalary(id)
				, HttpStatus.OK);
	}
	@GetMapping("search/{category}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> getAddSubSalaryByCategory(@PathVariable int category){		
		return new ResponseEntity<>(addSubSalaryService.getByCategory(category), HttpStatus.OK);
	}
}
