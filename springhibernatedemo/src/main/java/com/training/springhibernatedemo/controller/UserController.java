package com.training.springhibernatedemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.springhibernatedemo.dao.User;
import com.training.springhibernatedemo.dao.UserDao;

@RestController
public class UserController {

	@Autowired
	UserDao dao;
	
	@GetMapping("/users")
	public List<User> getAllUsers(){
		return dao.getAllUsers();
	}
	
	@PostMapping("/save")
	public String saveUser(@RequestBody User usr) {
		return dao.saveUser(usr);
	}
	
	@GetMapping("/user/{uid}")
	public User findUserById(@PathVariable Integer uid) {
		return dao.getUserById(uid);
	}
	
	@PutMapping("/user/{uid}")
	public User updateUser(@PathVariable Integer uid,@RequestBody User u) {
		return dao.updateUser(uid, u);
	}
	
	@DeleteMapping("/user/{uid}")
	public String deleteUserById(@PathVariable Integer uid) {
		return dao.deleteUser(uid);
	}
	
}
