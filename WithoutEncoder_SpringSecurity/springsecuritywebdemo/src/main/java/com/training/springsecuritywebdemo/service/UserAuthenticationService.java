package com.training.springsecuritywebdemo.service;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.training.springsecuritywebdemo.dao.UserInfo;
import com.training.springsecuritywebdemo.dao.UserReposiroty;

@Service
public class UserAuthenticationService implements UserDetailsService{
	
	@Autowired
	UserReposiroty repo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserInfo dbuser= repo.findByUsername(username)
				.orElseThrow(()->new RuntimeException(username + " not found in our db"));
		User secureduser = new User(dbuser.getUsername(),"{noop}"+dbuser.getPassword(),Collections.singletonList(new SimpleGrantedAuthority("dummy"))); 
		return secureduser;
	}

}
