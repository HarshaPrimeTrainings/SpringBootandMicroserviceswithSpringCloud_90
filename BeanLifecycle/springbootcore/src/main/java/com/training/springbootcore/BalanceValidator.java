package com.training.springbootcore;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(1)
@Component
public class BalanceValidator implements Validator{

	@Override
	public void validate(int amount) {
		int balance = 1000;
		if(amount<=balance) {
			System.out.println("=".repeat(7)+"Withdrawl Success"+"=".repeat(7));
		}else {
			System.out.println("=".repeat(7)+"Insuffecient Balance"+"=".repeat(7));
		}
		
	}

	
}
