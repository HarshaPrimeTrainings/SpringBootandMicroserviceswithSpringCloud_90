package com.training.orderservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.orderservice.dao.Order;
import com.training.orderservice.dao.OrderRepository;

@RestController
@RequestMapping("/order")
public class OrderController {

	@Autowired
	OrderRepository repo;
	
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
	
	@PostMapping("/save")
	public Order saveOrder(@RequestBody Order ord) {
		return repo.save(ord);
	}
	
	
	
}
