package com.training.billingapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class BillingappApplication {

	public static void main(String[] args) {
		ApplicationContext ioc = SpringApplication.run(BillingappApplication.class, args);
		Order order = ioc.getBean(Order.class);
		order.placeOrder();
		
	}

}
