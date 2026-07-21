package com.training.orderservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.orderservice.dao.Order;
import com.training.orderservice.dao.OrderRepository;

@RestController
@RequestMapping("/order")
public class OrderController {

	@Autowired
	OrderRepository repo;
	
	@GetMapping("/greet")
	public String greet(@RequestHeader("service_name") String serviceName) {
		
		return "Order Service Instance 2 wishing "+ serviceName;
	}
	
	
	@PostMapping("/msg")
	public String greetName(@RequestBody String msg) {
		return "Hello There !"+ msg;
	}
	
	@GetMapping("/all")
	public List<Order> getAllOrders(){
		return (List<Order>) repo.findAll();
	}
	
	
	@GetMapping("/{oid}")
	public Order getOrderById(@PathVariable Integer oid) {
		return repo.findById(oid).orElseThrow(()->new RuntimeException("Order not found :: "+ oid));
	}
	

	@GetMapping("/uid/{uid}")
	public List<Order> getOrderByUId(@PathVariable Integer uid) {
		return repo.findByUid(uid);
	}
	

	@GetMapping("/uidcount/{uid}")
	public Integer getOrderCountByUId(@PathVariable Integer uid) {
		return repo.getOrdecountforuid(uid);
	}
	
	@GetMapping("/uidjpql/{uid}")
	public Integer getOrderCountByUIdjpql(@PathVariable Integer uid) {
		return repo.getOrdecountforuidjpql(uid);
	}
	
	@PostMapping("/save")
	public Order saveOrder(@RequestBody Order ord) {
		return repo.save(ord);
	}
	
	
	
}
