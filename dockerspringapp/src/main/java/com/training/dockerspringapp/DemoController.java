package com.training.dockerspringapp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

	@GetMapping("/greet")
	public String greet() {
		
		return "<h1>Spring App with Docker</h1>";
	}
	
}
