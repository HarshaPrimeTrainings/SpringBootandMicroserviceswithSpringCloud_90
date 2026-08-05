package com.training.springsecuritywebdemo.service;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.training.springsecuritywebdemo.dao.UserInfo;
import com.training.springsecuritywebdemo.dao.UserReposiroty;

@Service
public class UserAuthenticationService implements UserDetailsService{
	
	
	@Autowired
	PasswordEncoder encoder;
	
	@Autowired
	UserReposiroty repo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserInfo dbuser= repo.findByUsername(username)
				.orElseThrow(()->new RuntimeException(username + " not found in our db"));
		
		Set<GrantedAuthority> authorities = new HashSet<>();
		
		dbuser.getRoles().stream().forEach(role->{
			authorities.add(()->role.getRole().name());
		});
		
		User secureduser = new User(dbuser.getUsername(),dbuser.getPassword(),authorities); 
		return secureduser;
	}

}
