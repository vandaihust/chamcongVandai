package com.vandai.mobi.controllers;


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

import com.vandai.mobi.model.CategoryAllowance;
import com.vandai.mobi.services.CategoryAllowanceService;



@RestController
@CrossOrigin("*")
@RequestMapping("api/categoryallowance")
public class CategoryAllowanceController {
	@Autowired
	CategoryAllowanceService categoryAllowanceService;
	@GetMapping
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> getCategoryAllowance(){
		return new ResponseEntity<>(categoryAllowanceService.getAllCategoryAllowance(), HttpStatus.OK);
	}
	@GetMapping("/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> getCategoryAllowanceById(@PathVariable int id){
		return new ResponseEntity<>(categoryAllowanceService.getCategoryAllowanceById(id), HttpStatus.OK);
	}
	@PostMapping
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> addCategoryAllowance(@RequestBody CategoryAllowance categoryAllowance){
		return new ResponseEntity<CategoryAllowance>(categoryAllowanceService.addCategoryAllowance(categoryAllowance)
				, HttpStatus.OK);
	}
	@PutMapping("{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> updateCategoryAllowance(@RequestBody CategoryAllowance categoryAllowance,@PathVariable int id){
		return new ResponseEntity<>(categoryAllowanceService.updateCategoryAllowance(id, categoryAllowance)
				, HttpStatus.OK);
	}
	@DeleteMapping("{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> deleteCategoryAllowance(@PathVariable int id){
		return new ResponseEntity<>(categoryAllowanceService.deleteCategoryAllowance(id)
				, HttpStatus.OK);
	}
}
