package com.training.springbootcore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Invoice {
	
	@Autowired
	Discount disc;
	
	public void finalbill(int amount) {
		System.out.println(disc.applyDiscount(amount));
	}
	
	
}


