package com.training.thymleafbootcampapp.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.training.thymleafbootcampapp.model.BootCamp;

import jakarta.annotation.PostConstruct;




@Controller
public class BootCampController {

	List<BootCamp> bootcamps = new ArrayList<>();
	
	@PostConstruct
	public void initBootcamps() {
		bootcamps.add(new BootCamp(1, "SpringBoot", LocalDate.of(2026,05,31)));
		bootcamps.add(new BootCamp(2, "Angular", LocalDate.of(2026,06,1)));
		bootcamps.add(new BootCamp(3, "Cloud", LocalDate.of(2026,07,4)));
		bootcamps.add(new BootCamp(4, "MicroServices", LocalDate.of(2026,05,30)));
	}
	
	@RequestMapping("/")
	public String home() {
		return "home";
	}
	
	
	@RequestMapping("/bootcamps")
	public ModelAndView shoeBootcamps() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("boocampList", bootcamps);
		mav.setViewName("bootcamplist");
		return mav;
	}
	
	@RequestMapping(value="/addbootcamp",method = RequestMethod.GET)
	public String addbootCamp() {
		return "addbootcamp";
	}
	
	
	@RequestMapping(value = "/savebootcamp",method = RequestMethod.POST)
	public ModelAndView saveBootcamp(BootCamp btcmp) {
		btcmp.setBid(bootcamps.size()+1);
		bootcamps.add(btcmp);
		ModelAndView mav = new ModelAndView();
		mav.addObject("boocampList", bootcamps);
		mav.setViewName("bootcamplist");
		return mav;
	}
	
	
	
}
