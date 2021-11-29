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

import com.vandai.mobi.model.Shirt;
import com.vandai.mobi.services.ShirtService;

@RestController
@CrossOrigin("*")
@RequestMapping("api/shirt")
public class ShirtController {
	@Autowired
	ShirtService shirtService;
	@GetMapping
	public ResponseEntity<?> getAllShirt(){
		if(shirtService.getAllShirt() == null) {
			shirtService.fakeDataShirt();
		}
		List<Shirt> listShirt = shirtService.getAllShirt();
		return new ResponseEntity<List<Shirt>>(listShirt, HttpStatus.OK);
	}
	@GetMapping("/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> getShirtById(@PathVariable int id){
		Shirt Shirt = shirtService.getShirtById(id);		
		return new ResponseEntity<>(Shirt, HttpStatus.OK);
	}
	@PostMapping
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> addShirt(@RequestBody Shirt Shirt){
		return new ResponseEntity<Shirt>(shirtService.addShirt(Shirt)
				, HttpStatus.OK);
	}
	@PutMapping("{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> updateShirt(@RequestBody Shirt shirt, @PathVariable int id){
		return new ResponseEntity<>(shirtService.updateShirt(shirt, id)
				, HttpStatus.OK);
	}
	@DeleteMapping("{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> deleteShirt(@PathVariable int id){
		return new ResponseEntity<>(shirtService.deleteShirt(id)
				, HttpStatus.OK);
	}
}
