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

import com.vandai.mobi.model.Salary;
import com.vandai.mobi.services.SalaryService;

@RestController
@RequestMapping("api/salary")
@CrossOrigin("*")
public class SalaryController {
	@Autowired
	SalaryService salaryService;
	@GetMapping
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> getAllSalary(){
		if(salaryService.getAllSalary() == null) {
			salaryService.fakeDataSalary();
		}
		List<Salary> listSalary = salaryService.getAllSalary();
		return new ResponseEntity<List<Salary>>(listSalary, HttpStatus.OK);
	}
	@GetMapping("/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> getSalaryById(@PathVariable int id){
		Salary Salary = salaryService.getSalaryById(id);		
		return new ResponseEntity<>(Salary, HttpStatus.OK);
	}
	@PostMapping
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> addSalary(@RequestBody Salary Salary){
		return new ResponseEntity<Salary>(salaryService.addSalary(Salary)
				, HttpStatus.OK);
	}
	@PutMapping("{coefficientsSalary}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> updateSalary(@RequestBody String basicSalary,@PathVariable int coefficientsSalary){
		String bas = basicSalary.substring(22, basicSalary.length()-1);
		return new ResponseEntity<>(salaryService.updateSalary(coefficientsSalary, Double.parseDouble(bas))
				, HttpStatus.OK);
	}
	@DeleteMapping("{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> deleteSalary(@PathVariable int id){
		return new ResponseEntity<>(salaryService.deleteSalary(id)
				, HttpStatus.OK);
	}
//	@DeleteMapping("all")
//	@PreAuthorize("hasRole('ADMIN')")
//	public ResponseEntity<?> deleteAllSalary(){
//		return new ResponseEntity<>(salaryService.deleteAllSalary()
//				, HttpStatus.OK);
//	}
//	@DeleteMapping("{ids}")
//	@PreAuthorize("hasRole('ADMIN')")
//	public ResponseEntity<?> deleteSalarySelected(@PathVariable List<String> ids){
//		SalaryService.deleteSalarySelected(ids);
//		return ResponseEntity.ok().body("Delete selected Salary success");
//	}
//	
//	@GetMapping("search/{name}")
//	@PreAuthorize("hasRole('ADMIN')")
//	public ResponseEntity<?> searchSalary(@PathVariable String name){
//		List<Salary> listSalary = SalaryService.getSalaryByName(name);
//		return new ResponseEntity<List<Salary>>(listSalary, HttpStatus.OK);
//	}
}
