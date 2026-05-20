package com.training.springbootcore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
public class SpringBeanLifeCycelDemo {
	
	SpringBeanLifeCycelDemo(){
		System.out.println("*".repeat(7)+" 1. Constructor "+"*".repeat(7));
	}

	@PostConstruct
	void spomemethod() {
		System.out.println("*".repeat(7)+"2. PostConstruct "+"*".repeat(7));
	}
	
	void customMethod() {
		System.out.println("*".repeat(7)+"3. Custom method "+"*".repeat(7));
	}
	
	@PreDestroy
	void desty() {
		System.out.println("*".repeat(7)+"4. PreDestroy "+"*".repeat(7));
	}
	
}
