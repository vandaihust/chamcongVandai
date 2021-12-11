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

import com.vandai.mobi.model.Rfid;
import com.vandai.mobi.services.RFIDService;

@RestController
@CrossOrigin("*")
@RequestMapping("api/rfid")
public class RFIDController {
	@Autowired
	RFIDService rFIDService;
	@GetMapping("employee/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> getRFIDByIdEmployee(@PathVariable long id){
		Rfid RFIDs = rFIDService.getRFIDByEmployee(id);	
		return new ResponseEntity<>(RFIDs, HttpStatus.OK);
	}
	@GetMapping
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> getAllRFID(){
		List<Rfid> RFIDs = rFIDService.getAllRFID();	
		return new ResponseEntity<>(RFIDs, HttpStatus.OK);
	}
	@GetMapping("/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> getRFIDById(@PathVariable int id){
		Rfid RFIDs = rFIDService.getRFIDById(id);	
		return new ResponseEntity<>(RFIDs, HttpStatus.OK);
	}
	@DeleteMapping("/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> deleteRFIDById(@PathVariable int id){
		String meg = rFIDService.deleteRFID(id);	
		return new ResponseEntity<>(meg, HttpStatus.OK);
	}
	@PostMapping("/{idEmployee}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> addRFID(@RequestBody Rfid RFID, @PathVariable long idEmployee){
		Rfid RFID2 = rFIDService.addRFID(RFID, idEmployee);			
		return new ResponseEntity<>(RFID2, HttpStatus.OK);
	}
	@PutMapping("{idEmployee}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> updateRFID(@RequestBody Rfid RFID, @PathVariable long idEmployee){
		Rfid RFID2 = rFIDService.updateRFID(RFID, idEmployee);			
		return new ResponseEntity<>(RFID2, HttpStatus.OK);
	}
}
