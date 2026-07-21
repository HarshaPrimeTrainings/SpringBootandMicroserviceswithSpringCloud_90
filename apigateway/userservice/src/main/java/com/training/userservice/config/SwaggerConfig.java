package com.training.userservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SwaggerConfig {

	@Bean
	OpenAPI configDoc() {

		OpenAPI opeapi = new OpenAPI();
		Info info = new Info();
		
		info.setTitle("User Service");
		info.setDescription("This a MicroService for User Crud Operations");
		info.setVersion("v1");
		info.setContact(new Contact().name("Admin").email("admin@company.com"));
		opeapi.info(info);
		return opeapi;
	}
}
