package com.vandai.mobi.controllers;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

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

import com.vandai.mobi.dto.InsuranceDto;
import com.vandai.mobi.model.Insurance;
import com.vandai.mobi.services.InsuranceService;

@RestController
@CrossOrigin("*")
@RequestMapping("api/insurance")
public class InsuranceController {
	
	@Autowired
	InsuranceService insuranceService;
	@GetMapping("employee/{idEmployee}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> getInsuranceByEmployee(@PathVariable long idEmployee){
		return new ResponseEntity<>(insuranceService.getByEmployee(idEmployee), HttpStatus.OK);
	}
	@GetMapping("/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> getInsuranceById(@PathVariable long id){	
		return new ResponseEntity<>(insuranceService.getById(id), HttpStatus.OK);
	}
	@PostMapping("employee/{idEmployee}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> addInsurance(@RequestBody InsuranceDto insuranceDto, @PathVariable long idEmployee){
		return new ResponseEntity<Insurance>(insuranceService.addInsurance(idEmployee, insuranceDto)
				, HttpStatus.OK);
	}
	@PutMapping("employee/{idEmployee}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> updateInsurance(@RequestBody InsuranceDto insuranceDto,@PathVariable int idEmployee){
		return new ResponseEntity<>(insuranceService.updateInsurance(idEmployee, insuranceDto)
				, HttpStatus.OK);
	}
	@DeleteMapping("{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> deleteInsurance(@PathVariable int id){
		return new ResponseEntity<>(insuranceService.deleteInsurance(id)
				, HttpStatus.OK);
	}
	@GetMapping("search/category/{category}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> getInsuranceByCategory(@PathVariable String category){
		return new ResponseEntity<>(insuranceService.getByCategoryContaining(category) , HttpStatus.OK);
	}
	@GetMapping("search/addressregister/{addressregister}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> getInsuranceByAddressRegister(@PathVariable String addressregister){
		return new ResponseEntity<>(insuranceService.getByAddressReigisterContaining(addressregister) , HttpStatus.OK);
	}
	@GetMapping("search/startat?{startAt}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> getInsuranceByStartAt(@PathVariable Date startAt){
		System.out.println(startAt);
		return new ResponseEntity<>(insuranceService.getByStartAt(startAt) , HttpStatus.OK);
	}
	@GetMapping("search/expiration/{expiration}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> getInsuranceByExpiration(@PathVariable Date expiration){
		return new ResponseEntity<>(insuranceService.getByExpirationAt(expiration) , HttpStatus.OK);
	}
		
}
