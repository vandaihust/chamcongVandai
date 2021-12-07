package com.vandai.mobi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vandai.mobi.services.AddressService;

@RestController
@CrossOrigin("*")
@RequestMapping("api/address")
public class AddressController {
	@Autowired
	AddressService addressService;
	@GetMapping("province/{name}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> searchByProvince(@PathVariable String name){
		return new ResponseEntity<>(addressService.searchProvince(name), HttpStatus.OK);
	}
	@GetMapping("province/{id}/district/{name}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> searchByProvinceAndDistrict(@PathVariable String name, @PathVariable int id){
		return new ResponseEntity<>(addressService.searchDistrict(id, name), HttpStatus.OK);
	}
	@GetMapping("province/{idProvince}/district/{idDistrict}/ward/{name}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> searchByProvinceAndDistrictAndWard(@PathVariable String name, @PathVariable int idProvince,@PathVariable int idDistrict){
		return new ResponseEntity<>(addressService.searchWard(idProvince, idDistrict, name), HttpStatus.OK);
	}
}
