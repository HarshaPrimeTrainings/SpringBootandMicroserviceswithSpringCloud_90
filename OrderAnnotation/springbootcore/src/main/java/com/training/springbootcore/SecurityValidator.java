package com.training.springbootcore;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(2)
@Component
public class SecurityValidator implements Validator{

	@Override
	public void validate(int amount) {
		System.out.println("=".repeat(7)+"Security Validation Done"+"=".repeat(7));
	}

}
