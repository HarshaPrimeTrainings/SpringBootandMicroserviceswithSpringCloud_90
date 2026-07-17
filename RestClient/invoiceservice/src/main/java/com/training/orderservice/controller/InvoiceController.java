package com.training.orderservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InvoiceController {

	@GetMapping("/invoice")
	public String greet() {
		return "Invoice Greeting to you !!!!!!";
	}
	
}
