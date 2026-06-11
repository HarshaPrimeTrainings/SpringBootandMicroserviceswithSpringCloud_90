package com.training.userservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.training.userservice.dao.User;
import com.training.userservice.services.UserService;


@RequestMapping("/user")
@RestController
public class UserController {

	@Autowired
	UserService service;

	@RequestMapping("/greet")
	public String greet() {
		return "Hello from RestController";
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<User>> getUsers(){
		return new ResponseEntity<List<User>>(service.getUsers(), HttpStatus.OK) ;
	}
	
	@PostMapping(value = "/save")
	public ResponseEntity<User> saveUser(@RequestBody User usr) {
		return new ResponseEntity<User>(service.saveUser(usr), HttpStatus.CREATED);
	}
	
	@GetMapping("/{uid}")
	public ResponseEntity<User> getUserById(@PathVariable Integer uid) {
		return ResponseEntity.status(HttpStatus.OK)
				.body(service.getUserById(uid));
	}
	
	@GetMapping("/param")
	public ResponseEntity<User> findUserById(@RequestParam Integer uid) {
		return ResponseEntity.status(HttpStatus.OK)
				.body(service.getUserById(uid));
	}
	
	@PutMapping("/update/{uid}")
	public ResponseEntity<User> updateUser(@PathVariable Integer uid,@RequestBody User usr) {
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(service.updateUser(uid, usr));
	}
	
	@PatchMapping("/updatepartial/{uid}")
	public ResponseEntity<User> updateUserpartial(@PathVariable Integer uid,@RequestBody User usr) {
		return ResponseEntity.status(HttpStatus.ACCEPTED)
				.body(service.updateUserpartial(uid, usr));
	}
	
	@DeleteMapping("/delete/{name}")
	public ResponseEntity<String> deleteUser(@PathVariable String name) {
		return ResponseEntity.status(HttpStatus.ACCEPTED)
				.body(service.deleteUser(name));
	}
	
}
