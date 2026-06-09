package com.training.userservice.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.training.userservice.UserserviceApplication;
import com.training.userservice.dao.User;
import com.training.userservice.services.UserService;

import jakarta.annotation.PostConstruct;

@RestController
public class UserController {

	@Autowired
	UserService service;

	@RequestMapping("/greet")
	public String greet() {
		return "Hello from RestController";
	}
	
	@GetMapping("/users")
	public List<User> getUsers(){
		return service.getUsers();
	}
	
	@PostMapping(value = "/save")
	public User saveUser(@RequestBody User usr) {
		return service.saveUser(usr);
	}
	
	@GetMapping("/user/{uid}")
	public User getUserById(@PathVariable Integer uid) {
		return service.getUserById(uid);
	}
	
	@GetMapping("/userparam")
	public User findUserById(@RequestParam Integer uid) {
		return service.getUserById(uid);
	}
	
	@PutMapping("/update/{uid}")
	public User updateUser(@PathVariable Integer uid,@RequestBody User usr) {
		return service.updateUser(uid, usr);
	}
	
	@PatchMapping("/updatepartial/{uid}")
	public User updateUserpartial(@PathVariable Integer uid,@RequestBody User usr) {
		return service.updateUserpartial(uid, usr);
	}
	
	@DeleteMapping("/delete/{name}")
	public String deleteUser(@PathVariable String name) {
		return service.deleteUser(name);
	}
	
}
