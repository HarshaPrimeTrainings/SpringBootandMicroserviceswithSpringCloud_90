package com.training.springsecuritywebdemo.controller;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.training.springsecuritywebdemo.dao.Role;
import com.training.springsecuritywebdemo.dao.RoleRepository;
import com.training.springsecuritywebdemo.dao.Roles;
import com.training.springsecuritywebdemo.dao.UserDto;
import com.training.springsecuritywebdemo.dao.UserInfo;
import com.training.springsecuritywebdemo.dao.UserReposiroty;

@RestController
public class UserController {

	@Autowired
	UserReposiroty repo;
	
	@Autowired
	RoleRepository roleRepo;
	
	@Autowired
	PasswordEncoder encoder;
	
	@PostMapping("/save")
	public UserInfo saveUser(@RequestBody UserDto user) {
		user.setPassword(encoder.encode(user.getPassword()));
		
		UserInfo userInfo = new UserInfo();
		
		Set<String> payloadRoles = user.getRoles();
		
		Set<Roles> dbRoles = new HashSet<>();
		userInfo.setUsername(user.getUsername());
		userInfo.setPassword(user.getPassword());
		
		payloadRoles.stream().forEach(role->{
			  Roles userRoles = roleRepo.findByRole(Role.valueOf(role)).orElseThrow(()->new RuntimeException("ROLE NOT FOUND"));
			  dbRoles.add(userRoles);
		});
		
		userInfo.setRoles(dbRoles);
		return repo.save(userInfo);
	}
}
