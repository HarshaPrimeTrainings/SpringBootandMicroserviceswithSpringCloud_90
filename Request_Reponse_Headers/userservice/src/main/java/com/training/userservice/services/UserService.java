package com.training.userservice.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.training.userservice.dao.User;
import com.training.userservice.exceptions.UserNotFoundException;

import jakarta.annotation.PostConstruct;

@Service
public class UserService {

	List<User> userList = new ArrayList<>();
	
	@PostConstruct
	void initUsers() {
		userList.add(new User(1, "vivek", "989082192", "HYD"));
		userList.add(new User(2, "Joe", "123456", "NYC"));
		userList.add(new User(3, "chandler", "7897546", "CHG"));
		userList.add(new User(4, "Ross", "65456432", "OHIO"));
		userList.add(new User(5, "Monika", "123546", "CND"));
		userList.add(new User(6, "Pheebe", "879432", "TEXAS"));
	}
	
	public List<User> getUsers(){
		return userList;
	}
	
	public User saveUser(User usr) {
		userList.add(usr);
		return userList.stream()
				.filter(u->u.getUid()==usr.getUid()).findFirst().orElse(null);
	}

	public User getUserById(Integer uid) {
		return userList.stream()
				.filter(u->u.getUid()==uid).findFirst()
				.orElseThrow(()->new UserNotFoundException("User Not found "+ uid));
	}
	
	public User updateUser(Integer uid,User usr) {
		User existing = userList.stream()
		.filter(u->u.getUid()==uid).findFirst()
		.orElseThrow(()->new UserNotFoundException("User Not found "+ uid));
		
		existing.setName(usr.getName());
		existing.setAddr(usr.getAddr());
		existing.setContact(usr.getContact());
		return existing;
	}
	
	public User updateUserpartial(Integer uid,User usr) {
		User existing = userList.stream()
		.filter(u->u.getUid()==uid).findFirst()
		.orElseThrow(()->new UserNotFoundException("User Not found "+ uid));
		
		existing.setName(usr.getName()!=null?usr.getName():existing.getName());
		existing.setAddr(usr.getAddr()!=null?usr.getAddr():existing.getAddr());
		existing.setContact(usr.getContact()!=null?usr.getContact():existing.getContact());
		return existing;
	}
	
	public User getUserByName(String name) {
		User existing = userList.stream()
				.filter(u->u.getName().equalsIgnoreCase(name)).findFirst()
				.orElseThrow(()->new UserNotFoundException("User Not found "+ name));
		return existing;
	}
	
	public String deleteUser(String name) {
		 userList.remove(getUserByName(name));
		 return "User Deleted Succefully";
	}
}
