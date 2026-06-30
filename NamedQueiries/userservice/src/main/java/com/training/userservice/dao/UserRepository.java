package com.training.userservice.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer>{

	public User findByName(String name);
	
	public List<User> findByAddr(String addr);
}
