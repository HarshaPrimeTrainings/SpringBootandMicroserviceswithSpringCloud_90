package com.training.userservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestConfig {

//	@Bean
//	RestTemplate initRest() {
//		return new RestTemplate();
//	}
	
	@Bean("orderrestclient")
	RestClient orderRestClient() {
		return RestClient.builder().baseUrl("http://localhost:7070/order").build();
	}
	
	@Bean("invoicerestclient")
	RestClient invoiceRestClient() {
		return RestClient.builder().baseUrl("http://localhost:7079").build();
	}
	
}
