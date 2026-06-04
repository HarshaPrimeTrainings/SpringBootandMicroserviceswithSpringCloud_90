package com.training.thymleafbootcampapp.model;

import java.util.ArrayList;
import java.util.List;


public class Bootcamps {
	
	List<BootCamp> bootCamps;

	public Bootcamps(List<BootCamp> bootCamps) {
		this.bootCamps = bootCamps;
	}

	public List<BootCamp> getBootCamps() {
		return bootCamps;
	}

	public void setBootCamps(List<BootCamp> bootCamps) {
		this.bootCamps = bootCamps;
	}

	public List<BootCamp> addBootCamp(BootCamp bootcamp){
		bootCamps.add(bootcamp);
		return bootCamps;
	}
	
	
	

}
