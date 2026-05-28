package com.training.springbootjsp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
// model -. jsp
	
	@RequestMapping("/home")
	public String home(Model model) {
		model.addAttribute("msg","Hello There !!!!!!!");
		User u = new User(1, "vivek", "hyd");
		model.addAttribute("u", u);
		return "home";
	}
	
	@RequestMapping("/greet")
	public ModelAndView greet() {
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("version", "1.0");
		User u = new User(1, "vivek", "hyd");
		mav.addObject("usr",u);
		
		mav.setViewName("greet");
		return mav;
	}
	
	

	// /WEB-INF/home.jsp
}
