package com.app.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class Welcome {
	
	

	@GetMapping("/hello")
	public String hello() {
		return "Hello";
	}

	@PreAuthorize("hasRole('USER')")
	@GetMapping("/user")
	public String userEndpoint() {
		return "Hello, User!";
	}

	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/admin")
	public String adminEndpoint() {
		return "Hello, Admin!";
	}
	
	
}
