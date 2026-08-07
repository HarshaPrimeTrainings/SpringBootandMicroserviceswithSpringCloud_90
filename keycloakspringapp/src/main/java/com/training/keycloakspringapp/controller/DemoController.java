package com.training.keycloakspringapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
	
	@GetMapping("/health")
	public String greetHealth() {
		return  "Service Up Healthy";
	}

	@GetMapping("/user")
	public String greetUser() {
		return "Hello User";
	}
	
	@GetMapping("/admin")
	public String greetAdmin() {
		return "Hello Admin";
	}
	
}
