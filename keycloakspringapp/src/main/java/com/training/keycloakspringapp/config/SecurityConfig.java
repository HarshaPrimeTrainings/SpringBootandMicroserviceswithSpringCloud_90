package com.training.keycloakspringapp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

	@Autowired
	JwtConvertor convertor;
	
	
	@Bean
	SecurityFilterChain intSecurity(HttpSecurity http) {
		http.authorizeHttpRequests(auth->auth.requestMatchers("/health").permitAll()
				.requestMatchers("/admin").hasAnyRole("ADMIN")
				.anyRequest().authenticated())
		.oauth2ResourceServer(oauth->oauth.jwt(jwt->jwt.jwtAuthenticationConverter(convertor)))
		.logout(logout->logout.permitAll())
		.csrf(csrf->csrf.disable());
		
		return http.build();
		
	}
}
