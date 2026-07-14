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
import com.training.multidatabaseservice.pgdb.Adress;
import com.training.multidatabaseservice.pgdb.AdressRepository;

import jakarta.transaction.Transactional;


@RestController
@RequestMapping("/emp")
public class EmployeeController {

	@Autowired
	EmployeeRepository empRepo;
	
	@Autowired
	AdressRepository addRepo;
	
	@PostMapping("/addr/save")
	@Transactional
	public String saveEmpAddr(@RequestBody EmployeeDto empdto) {
		
		Employee emp = new Employee();
		emp.setName(empdto.getName());
		emp.setContact(empdto.getContact());
		emp.setAid(empdto.getAid());
		empRepo.save(emp); 
		
		Adress addr = new Adress();
		addr.setCity(empdto.getAddr().getCity());
		addr.setState(empdto.getAddr().getState());
		if(addr.getCity()==null || addr.getState() == null) {
			throw new RuntimeException("Adress Details are required City/State detils are missing");
		}
		
		addRepo.save(addr); 
		
		return "Employee Detils Saved With Addresss";
		
	}
	
	
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

