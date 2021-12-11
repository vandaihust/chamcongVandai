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

import com.vandai.mobi.model.Allowance;
import com.vandai.mobi.services.AllowanceService;
@RestController
@CrossOrigin("*")
@RequestMapping("api/allowance")
public class AllowanceController {
	@Autowired
	AllowanceService allowanceService;
	@GetMapping("employee/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> getAllowanceByIdEmployee(@PathVariable long id){
		List<Allowance> allowances = allowanceService.getAllowanceEmployee(id);	
		return new ResponseEntity<>(allowances, HttpStatus.OK);
	}
	@GetMapping
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> getAllAllowance(){
		List<Allowance> Allowances = allowanceService.getAllAllowance();	
		return new ResponseEntity<>(Allowances, HttpStatus.OK);
	}
	@GetMapping("/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> getAllowanceById(@PathVariable int id){
		Allowance Allowances = allowanceService.getAllowanceById(id);	
		return new ResponseEntity<>(Allowances, HttpStatus.OK);
	}
	@DeleteMapping("/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> deleteAllowanceById(@PathVariable int id){
		String meg = allowanceService.deleteAllowance(id);	
		return new ResponseEntity<>(meg, HttpStatus.OK);
	}
	@PostMapping("/{idEmployee}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> addAllowance(@RequestBody Allowance Allowance, @PathVariable long idEmployee){
		Allowance Allowance2 = allowanceService.addAllowance(Allowance, idEmployee);			
		return new ResponseEntity<>(Allowance2, HttpStatus.OK);
	}
	@PutMapping("employee/{idEmployee}/allowance/{idAllowance}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> addAllowance(@RequestBody Allowance Allowance, @PathVariable long idEmployee,@PathVariable int idAllowance){
		Allowance Allowance2 = allowanceService.updateAllowance(Allowance, idAllowance, idEmployee);			
		return new ResponseEntity<>(Allowance2, HttpStatus.OK);
	}
}
