package com.vandai.mobi.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/test")
@CrossOrigin(origins = "*")
public class TestController {
	@GetMapping("/all")
	public String allAccess() {
		return "Mọi đối tượng";
	}
	
	@GetMapping("/user")
	@PreAuthorize("hasRole('USER') or hasRole('SUPPORT') or hasRole('ADMIN')")
	public String userAccess() {
		return "Trang dành cho user";
	}

	@GetMapping("/support")
	@PreAuthorize("hasRole('SUPPORT') or hasRole('ADMIN')")
	public String moderatorAccess() {
		return "Trang dành cho support";
	}

	@GetMapping("/admin")
	@PreAuthorize("hasRole('ADMIN')")
	public String adminAccess() {
		return "Trang dành cho admin.";
	}
}
