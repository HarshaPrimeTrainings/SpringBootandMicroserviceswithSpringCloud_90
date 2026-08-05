package com.training.springsecuritywebdemo.dao;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface UserReposiroty extends CrudRepository<UserInfo, Integer>{

	Optional<UserInfo> findByUsername(String username);
}
