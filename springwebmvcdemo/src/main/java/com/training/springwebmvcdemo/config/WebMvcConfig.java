package com.training.springwebmvcdemo.config;

import java.util.ArrayList;
import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;


@Configuration
public class WebMvcConfig {

	@Bean
	Demo initDemo() {
		Demo d =new Demo();
		d.msg = "Hello There";
		return d;
	}

	@Bean
	ViewResolver initResolver() {
		InternalResourceViewResolver iv = new InternalResourceViewResolver();
		iv.setPrefix("/views/"); // static
		iv.setSuffix(".html"); 
		return iv;
	}
	
	//static/home.html
	//static/views/home.html
}
