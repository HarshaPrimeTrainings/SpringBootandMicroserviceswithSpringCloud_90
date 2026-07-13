package com.training.multidatabaseservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.multidatabaseservice.mysql.Employee;
import com.training.multidatabaseservice.mysql.EmployeeRepository;

@RestController
@RequestMapping("/emp")
public class EmployeeController {

	@Autowired
	EmployeeRepository empRepo;
	
	
	
	@PostMapping("/save")
	public Employee saveEmp(@RequestBody Employee emp) {
		return empRepo.save(emp);
	}
	
	@GetMapping("/all")
	public List<Employee> getEmployees(){
		return (List<Employee>) empRepo.findAll();
	}
	
	@GetMapping("/{id}")
	public Employee getEmpById(@PathVariable Integer id) {
		return empRepo.findById(id).orElseThrow(()->new RuntimeException("EMP not found"));
	}
	
	
}

