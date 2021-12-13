package com.vandai.mobi.controllers;

import java.sql.Date;

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

import com.vandai.mobi.model.Reader;
import com.vandai.mobi.services.ReaderService;

@RestController
@CrossOrigin("*")
@RequestMapping("api/reader")
public class ReaderController {
	@Autowired
	ReaderService readerService;
	@GetMapping
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> getAllReader(){
		return new ResponseEntity<>( readerService.getAllReader(), HttpStatus.OK);
	}
	@GetMapping("/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> getReaderById(@PathVariable int id){
		Reader Readers = readerService.getReaderById(id);	
		return new ResponseEntity<>(Readers, HttpStatus.OK);
	}
	@DeleteMapping("/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> deleteReaderById(@PathVariable int id){
		String meg = readerService.deleteReader(id);	
		return new ResponseEntity<>(meg, HttpStatus.OK);
	}
	@PostMapping
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> addReader(@RequestBody Reader reader){
		Reader Reader2 = readerService.addReader(reader);			
		return new ResponseEntity<>(Reader2, HttpStatus.OK);
	}
	@PutMapping("{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> updateReader(@RequestBody Reader reader, @PathVariable int id){
		Reader Reader2 = readerService.updateReader(reader, id);			
		return new ResponseEntity<>(Reader2, HttpStatus.OK);
	}
	
	@GetMapping("idStr/{idStr}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> getReaderByIdReader(@PathVariable String idStr){
		return new ResponseEntity<>( readerService.getReaderByIdReader(idStr), HttpStatus.OK);
	}
	@GetMapping("name/{name}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> searchByName(@PathVariable String name){
		return new ResponseEntity<>( readerService.getByNameContaining(name), HttpStatus.OK);
	}
	@GetMapping("address/{address}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> searchByAddress(@PathVariable String address){
		return new ResponseEntity<>( readerService.getByAddressContaining(address), HttpStatus.OK);
	}
	@GetMapping("status/{status}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> searchByStatus(@PathVariable int status){
		return new ResponseEntity<>( readerService.getByStatus(status), HttpStatus.OK);
	}
	@GetMapping("date/{date}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> searchByDateBuy(@PathVariable Date date){
		return new ResponseEntity<>( readerService.getByDateBy(date), HttpStatus.OK);
	}
	@GetMapping("addressupply/{addressupply}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> searchByAddressSupply(@PathVariable String addressupply){
		return new ResponseEntity<>( readerService.getByAddressSupply(addressupply), HttpStatus.OK);
	}
	@GetMapping("department/{department}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> searchByDepartmentUser(@PathVariable String department){
		return new ResponseEntity<>( readerService.getByDepartmentUse(department), HttpStatus.OK);
	}
}
