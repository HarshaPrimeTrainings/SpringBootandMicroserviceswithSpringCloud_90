package com.training.springsecuritywebdemo.dao;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface RoleRepository extends CrudRepository<Roles, Integer>{
	
	public Optional<Roles> findByRole(Role Role);

}
