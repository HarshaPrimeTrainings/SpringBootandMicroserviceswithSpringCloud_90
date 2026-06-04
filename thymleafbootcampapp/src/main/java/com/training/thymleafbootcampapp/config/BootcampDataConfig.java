package com.training.thymleafbootcampapp.config;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.training.thymleafbootcampapp.model.BootCamp;
import com.training.thymleafbootcampapp.model.Bootcamps;

@Configuration
public class BootcampDataConfig {
	
	@Bean
	Bootcamps initBootcamps() {
		List<BootCamp> bootcampList = new ArrayList<BootCamp>();
		bootcampList.add(new BootCamp(1, "SpringBoot", LocalDate.of(2026,05,31)));
		bootcampList.add(new BootCamp(2, "Angular", LocalDate.of(2026,06,1)));
		bootcampList.add(new BootCamp(3, "Cloud", LocalDate.of(2026,07,4)));
		bootcampList.add(new BootCamp(4, "MicroServices", LocalDate.of(2026,05,30)));
		Bootcamps bootcamps = new Bootcamps(bootcampList);
		return bootcamps;
	}
	
	
}
