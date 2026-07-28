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

import io.micrometer.observation.ObservationRegistry;

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
	RestClient.Builder defaultBuilder(ObservationRegistry obr){
		return RestClient.builder().observationRegistry(obr);
	}
	
	
	@LoadBalanced
	@Bean("lbrestclient")
	RestClient.Builder lbBuilder(ObservationRegistry obr){
		return RestClient.builder().observationRegistry(obr);
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
