package com.training.userservice.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends CrudRepository<User, Integer> {

	public User findByName(String name);

	public List<User> findByAddr(String addr);

	// NatieveQury
	@Query(value = "select count(*) from user where addr=:addr", nativeQuery = true)
	public Integer getUserCountofAddr(String addr);

	// JPQL
	@Query(value = "select count(u) from User u where u.addr=:addr")
	public Integer getUserCountofAddrjpql(@Param("addr") String addr);

	// JPQL
	@Query(value = "select u from User u where u.addr=:addr")
	public List<User> getUseofAddrjpql(String addr);
}
