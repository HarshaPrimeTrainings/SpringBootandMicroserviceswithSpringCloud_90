package com.training.orderservice.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface OrderRepository extends CrudRepository<Order, Integer>{

	public List<Order> findByUid(Integer uid);
	
	//Natieve SQL
	@Query(value = "select count(*) from orderdetails where uid=:uid",nativeQuery = true)
	public Integer getOrdecountforuid(Integer uid);
	
	// JPQL
	@Query(value = "select count(o) from Order o where o.uid=:uid")
	public Integer getOrdecountforuidjpql(Integer uid);
	
}
