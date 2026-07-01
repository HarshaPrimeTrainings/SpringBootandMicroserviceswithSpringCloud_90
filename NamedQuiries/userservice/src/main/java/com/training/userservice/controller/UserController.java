package com.training.userservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
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

	@PostMapping(value = "/greet",produces = MediaType.TEXT_PLAIN_VALUE,consumes = MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<String> greet(@RequestBody String msg) {
		System.out.println(msg);
		return new ResponseEntity<String>("<h1>Hello form RestController</h1>", HttpStatus.OK);
	}
	
	@GetMapping(value = "/all")
	public ResponseEntity<?> getUsers(@RequestParam(defaultValue = "json") String format,@RequestHeader("user-agent") String reqheader){
		System.out.println(reqheader);
		String media = MediaType.APPLICATION_JSON_VALUE;
		if(format.contains("xml")) {
			 media = MediaType.APPLICATION_XML_VALUE;
		}
		HttpHeaders headers = new HttpHeaders();
		headers.add("msg", "this is from userapi");
		headers.add("user_count",service.getUsers().size()+"");
		headers.add("content-type",media);
		return new ResponseEntity<List<User>>(service.getUsers(),headers, HttpStatus.OK);
	}
	
	
	
	@PostMapping(value = "/save")
	public ResponseEntity<User> saveUser(@RequestBody User usr) {
		System.out.println("Password :: "+usr.getPasswrod());
		return new ResponseEntity<User>(service.saveUser(usr), HttpStatus.CREATED);
	}
	
	@GetMapping(value = "/{uid}")
	public ResponseEntity<User> getUserById(@RequestParam(defaultValue = "json") String format,@PathVariable Integer uid) {
		MediaType media = format.contains("xml")?MediaType.APPLICATION_XML:MediaType.APPLICATION_JSON;
		HttpHeaders headers = new HttpHeaders();
		headers.add("msg", "this is from userapi");
		headers.add("user_count",service.getUsers().size()+"");
		
		return ResponseEntity.status(HttpStatus.OK)
				.headers(headers)
				.contentType(media)
				.body(service.getUserById(uid));
	}
	
	@GetMapping("/name/{name}")
	public User getUserByName(@PathVariable String name) {
		return service.getUserByName(name);
	}
	
	@GetMapping("/addr/{addr}")
	public List<User> getUsersByaddr(@PathVariable String addr) {
		return service.getUsersByAddr(addr);
	}
	
	@GetMapping("/addrcount/{addr}")
	public Integer getUserCountByaddr(@PathVariable String addr) {
		return service.getUserCountofAddr(addr);
	}
	
	@GetMapping("/jpqlcount/{addr}")
	public Integer getUserCountByaddrJPQL(@PathVariable String addr) {
		return service.getUserCountofAddrJPQL(addr);
	}
	
	@GetMapping("/jpqlusers/{addr}")
	public List<User> getUsersofAddrJPQL(@PathVariable String addr) {
		return service.getUsersofAddrJPQL(addr);
	}
	
	@GetMapping("/param")
	public ResponseEntity<User> findUserById(@RequestParam Integer uid) {
		return ResponseEntity
				.status(HttpStatus.OK)
				.header("msg", "this is from userapi")
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
	
	@DeleteMapping("/delete/{uid}")
	public ResponseEntity<String> deleteUser(@PathVariable Integer uid) {
		return ResponseEntity.status(HttpStatus.ACCEPTED)
				.body(service.deleteUser(uid));
	}
	
}
