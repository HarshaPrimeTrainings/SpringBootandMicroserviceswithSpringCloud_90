package com.training.multidatabaseservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.multidatabaseservice.pgdb.Student;
import com.training.multidatabaseservice.pgdb.StudentRepositoty;

@RestController
@RequestMapping("/std")
public class StudentController {
	
	@Autowired
	StudentRepositoty stdRepo;

	@PostMapping("/save")
	public Student saveEmp(@RequestBody Student std) {
		return stdRepo.save(std);
	}
	
	@GetMapping("/all")
	public List<Student> getEmployees(){
		return (List<Student>) stdRepo.findAll();
	}
	
	@GetMapping("/{id}")
	public Student getEmpById(@PathVariable Integer id) {
		return stdRepo.findById(id).orElseThrow(()->new RuntimeException("Std not found"));
	}
}

