package com.training.userservice.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestConfig {
	
	@Value("${orderservice.url}")
	String orderserviceurl;
	

//	@Bean
//	RestTemplate initRest() {
//		return new RestTemplate();
//	}
	
	@Autowired
	UserServiceInterceptor useInterceptor;
	
	@Primary
	@Bean
	RestClient.Builder defaultBuilder(){
		return RestClient.builder();
	}
	
	
	@LoadBalanced
	@Bean("lbrestclient")
	RestClient.Builder lbBuilder(){
		return RestClient.builder();
	}
	
	
	@Bean("orderrestclient")
	RestClient orderRestClient(@Qualifier("lbrestclient") RestClient.Builder builder ) {
		return  builder
				.requestInterceptor(useInterceptor)
				.baseUrl(orderserviceurl).build();
	}
	
	@Bean("invoicerestclient")
	RestClient invoiceRestClient() {
		return RestClient.builder().baseUrl("http://localhost:7079").build();
	}
	
}
