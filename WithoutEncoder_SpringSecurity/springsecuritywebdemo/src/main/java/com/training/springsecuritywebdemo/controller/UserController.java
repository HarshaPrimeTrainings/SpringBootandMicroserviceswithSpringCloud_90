package com.training.springsecuritywebdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.training.springsecuritywebdemo.dao.UserInfo;
import com.training.springsecuritywebdemo.dao.UserReposiroty;

@RestController
public class UserController {

	@Autowired
	UserReposiroty repo;
	
	@PostMapping("/save")
	public UserInfo saveUser(@RequestBody UserInfo user) {
		return repo.save(user);
	}
}
