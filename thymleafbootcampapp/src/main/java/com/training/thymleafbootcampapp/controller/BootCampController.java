package com.training.thymleafbootcampapp.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.training.thymleafbootcampapp.model.BootCamp;
import com.training.thymleafbootcampapp.model.Bootcamps;

import jakarta.annotation.PostConstruct;




@Controller
public class BootCampController {

	@Autowired
	Bootcamps bootcamps;
	
	@RequestMapping("/")
	public String home() {
		return "home";
	}
	
	@RequestMapping("/searchbootcamp")
	public ModelAndView searchBootcamps(@RequestParam String search) {
		ModelAndView mav = new ModelAndView();
		List<BootCamp> filteredBootcamps = bootcamps.getBootCamps().stream()
		.filter(b->b.getTopic().toLowerCase().contains(search.toLowerCase()))
		.collect(Collectors.toList());
		mav.addObject("boocampList",filteredBootcamps );
		mav.setViewName("bootcamplist");
		return mav;
	}
	
	@RequestMapping("/bootcamps")
	public ModelAndView shoeBootcamps() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("boocampList", bootcamps.getBootCamps());
		mav.setViewName("bootcamplist");
		return mav;
	}
	
	@RequestMapping(value="/addbootcamp",method = RequestMethod.GET)
	public String addbootCamp() {
		return "addbootcamp";
	}
	
	
	@RequestMapping(value = "/savebootcamp",method = RequestMethod.POST)
	public ModelAndView saveBootcamp(BootCamp btcmp) {
		btcmp.setBid(bootcamps.getBootCamps().size()+1);
		bootcamps.addBootCamp(btcmp);
		ModelAndView mav = new ModelAndView();
		mav.addObject("boocampList", bootcamps.getBootCamps());
		mav.setViewName("bootcamplist");
		return mav;
	}
	
	
}
