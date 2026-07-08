package com.training.userservice.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends CrudRepository<User, Integer> {

	public User findByName(String name);
	
	@EntityGraph(attributePaths = {"contact"})
	public List<User> findAll();


	
}
