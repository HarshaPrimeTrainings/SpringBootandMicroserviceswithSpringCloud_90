package com.training.thymleafbootcampapp.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.training.thymleafbootcampapp.model.BootCamp;
import com.training.thymleafbootcampapp.model.Bootcamps;
import com.training.thymleafbootcampapp.model.Particepant;

@Controller
public class ParticepantController {
	
	List<Particepant> particepantList = new ArrayList<>();

	@Autowired
	Bootcamps bootcamps;
	
	BootCamp bootcamp;
	
	@RequestMapping("/addparticepant/{bid}")
	public ModelAndView addParticpant(@PathVariable Integer bid) {
	bootcamp = bootcamps.getBootCamps().stream().filter(b->b.getBid()==bid)
		.findFirst().orElse(null);
	ModelAndView mav = new ModelAndView();
	mav.addObject("bootcampdetail",bootcamp);
	mav.setViewName("particepant");
		return mav;
	}
	
	@RequestMapping(value="/saveparticepant",method = RequestMethod.POST)
	public ModelAndView saveParticepant(Particepant particepant) {
		particepant.setPid(particepantList.size()+1);
		particepantList.add(particepant);
		bootcamp.getParticepants().add(particepant);
		ModelAndView mav = new ModelAndView();
		mav.addObject("particepant", particepant);
		mav.addObject("bootcampdetail",bootcamp);
		mav.setViewName("particepantdetails");
		return mav;
	}
	
}
