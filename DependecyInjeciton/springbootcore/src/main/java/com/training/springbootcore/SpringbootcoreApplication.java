package com.training.springbootcore;

import com.training.springbootcore.model.Order;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.training.springbootcore.Product;

@SpringBootApplication
@ComponentScan(basePackages = {"com.training.springbootcore","org.training.springbootcore"})
public class SpringbootcoreApplication {


	public static void main(String[] args) {
		
		ApplicationContext ioc = SpringApplication.run(SpringbootcoreApplication.class, args);
		
		//User u = (User)ioc.getBean("user"); // By using ID
		Address addr = ioc.getBean(Address.class);
		addr.setCity("HYD");
		addr.setState("TG");
		addr.setZipcode("500031");
		
		User u = ioc.getBean(User.class); // By using class type
		u.setUid(1);
		u.setName("vivek");
		
		//u.setAddr(addr);
		
		
		System.out.println(u);
	}

}
