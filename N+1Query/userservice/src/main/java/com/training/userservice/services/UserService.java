package com.training.userservice.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.training.userservice.dao.User;
import com.training.userservice.dao.UserRepository;
import com.training.userservice.exceptions.UserNotFoundException;

import jakarta.annotation.PostConstruct;

@Service
public class UserService {
	
	@Autowired
	UserRepository repo;
	
	public List<User> getUsers(){
		return (List<User>) repo.findAll();
	}
	
	public User saveUser(User usr) {
		usr.getContact().stream().forEach(c->c.setUser(usr));
		return repo.save(usr);
	}

	public User getUserById(Integer uid) {
		return repo.findById(uid).orElseThrow(()->new UserNotFoundException("User Not found "+ uid));
	}
	
	public User updateUser(Integer uid,User usr) {
		User existing = getUserById(uid);
		
		existing.setName(usr.getName());
		existing.setContact(usr.getContact());
		return repo.save(existing);
		
	}
	
	public User updateUserpartial(Integer uid,User usr) {
		User existing = getUserById(uid);
		
		existing.setName(usr.getName()!=null?usr.getName():existing.getName());
		existing.setContact(usr.getContact()!=null?usr.getContact():existing.getContact());
		existing.setPasswrod(usr.getPasswrod()!=null?usr.getPasswrod():existing.getPasswrod());
		return repo.save(existing);
		
	}
	
	public User getUserByName(String name) {
		User existing = repo.findByName(name);
		return existing;
	}
	
	
	
	public String deleteUser(Integer uid) {
		 repo.deleteById(uid);
		 return "User Deleted Succefully";
	}
}
