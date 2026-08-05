package com.training.springsecuritywebdemo.cofig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
public class SecurityConfig {
	
	@Bean
	PasswordEncoder initEncode() {
		return new BCryptPasswordEncoder();
	}
	
	

	@Bean
	SecurityFilterChain configSecurity(HttpSecurity httpsecurity) {
		httpsecurity.authorizeHttpRequests(auth->
		auth
		.requestMatchers("/home","/save").permitAll()
		.requestMatchers("/admin")
		//.hasRole("ADMIN") // ROLE_ADMIN Single ROLE
		.hasAnyRole("ADMIN","MNGR") // Multi Roles
		//.hasAuthority("ADMIN")
		.anyRequest().authenticated())
		.formLogin(formlogin->formlogin.loginPage("/login").permitAll())
		.logout(logout->logout.permitAll())
		.csrf(csrf->csrf.disable());
		
		
		return httpsecurity.build();
	}
	
}
