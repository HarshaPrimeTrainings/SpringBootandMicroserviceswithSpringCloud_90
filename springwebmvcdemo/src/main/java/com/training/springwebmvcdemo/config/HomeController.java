package com.training.springwebmvcdemo.config;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@RequestMapping("/home")
	public String homePage() {
		return "home";
	}
	
	@RequestMapping("/greet")
	public String greet() {
		return "greet";
	}
	
	
	

}
