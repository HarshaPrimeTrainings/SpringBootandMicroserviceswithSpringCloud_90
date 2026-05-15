package com.training.springbootcore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Invoice {
	
	
	Discount disc;
	
	@Value("${dicscount.activate}")
	private String discType;

	public void finalbill(int amount) {
		if(discType.equals("mid")) {
			disc = new MidYearDiscount();
		}else {
			disc = new DefaultDiscountImpl();
		}
		
		System.out.println(disc.applyDiscount(amount));
	}
	
	
}


