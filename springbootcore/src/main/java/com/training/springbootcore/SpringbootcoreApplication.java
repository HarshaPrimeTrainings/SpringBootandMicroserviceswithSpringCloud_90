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
		
		User u = ioc.getBean(User.class); // By using class type
		u.setUid(1);
		u.setName("vivek");
		u.setAddr("HYD");
		
		User u1 = ioc.getBean(User.class);
		u1.setUid(2);
		u1.setName("anand");
		u1.setAddr("BANG");
		
		System.out.println(u);
		System.out.println(u1);
		
		Order o = ioc.getBean(Order.class);
		o.setOid(1);
		o.setStatus("delivered");
		System.out.println(o);
		
		Product p = ioc.getBean(Product.class);
		p.setPid(1);
		p.setCatagery("electronics");
		p.setPrice(100);
		System.out.println(p);
	}

}
