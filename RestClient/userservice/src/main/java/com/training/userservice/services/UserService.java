package com.training.userservice.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestClient;

import com.training.userservice.dao.User;
import com.training.userservice.dao.UserRepository;
import com.training.userservice.dto.AddressDto;
import com.training.userservice.dto.OrderDto;
import com.training.userservice.dto.UserDto;
import com.training.userservice.exceptions.UserNotFoundException;

import jakarta.annotation.PostConstruct;

@Service
public class UserService {
	
	@Autowired
	UserRepository repo;
	
	@Qualifier("orderrestclient")
	@Autowired
	RestClient orderrestclient;
	
	@Qualifier("invoicerestclient")
	@Autowired
	RestClient invoiceCllient;
	
	public String greetfromOrder() {
		//http://localhost:7070/order
		return orderrestclient.get().uri("/greet").retrieve().body(String.class);
	}
	
	public String greetFromInvoice() {
		//http://localhost:7079
		return invoiceCllient.get().uri("/invoice").retrieve().body(String.class);
	}
	
	
	public List<OrderDto> getOrdersByUid(Integer uid) {
		//return orderrestclient.get().uri("/uid/"+uid).retrieve().body(List.class);
		return orderrestclient.get().uri("/uid/{uid}",uid).retrieve().body(List.class);
	}
	
	public OrderDto postOrder(OrderDto order) {
		return orderrestclient.post()
					.uri("/save")
					.body(order) // Request Body
					.contentType(MediaType.APPLICATION_JSON)
					.retrieve()
					.body(OrderDto.class); // Response Body
	}
	
	public UserDto getUserOrders(Integer uid) {
		UserDto userDto = new UserDto();
		
		User userEntity = getUserById(uid);
		userDto.setUid(userEntity.getUid());
		userDto.setName(userEntity.getName());
		userDto.setPasswrod(userEntity.getPasswrod());
		
		AddressDto addrDto = new AddressDto();
		addrDto.setAid(userEntity.getAddr().getAid());
		addrDto.setCity(userEntity.getAddr().getCity());
		addrDto.setState(userEntity.getAddr().getState());
		addrDto.setZipcode(userEntity.getAddr().getZipcode());
		userDto.setAddr(addrDto);
		
		userDto.setOrders(getOrdersByUid(uid));
		
		return userDto;
		
	}
	
	
	
	// pageSize -> records per page
	// pageNumber -> starts from 0
	public List<User> getAllPaginatedUsers(Integer pageSize,Integer pageNumber){
		Pageable pageable = PageRequest.of(pageNumber, pageSize);
		Page<User> page = repo.findAll(pageable);
		return page.toList();
	}
	
	public List<User> getSortedUsers(String sortkey,String sortOrder){
		if(sortOrder.equalsIgnoreCase("desc")) {
		return repo.findAll(Sort.by(sortkey).descending());
		}
		return repo.findAll(Sort.by(sortkey));
	}
	
	
	
	
	public List<User> getUsers(){
		return (List<User>) repo.findAll();
	}
	
	
	public User saveUser(User usr) {
		return repo.save(usr);
	}

	public User getUserById(Integer uid) {
		return repo.findById(uid).orElseThrow(()->new UserNotFoundException("User Not found "+ uid));
	}
	
	public User updateUser(Integer uid,User usr) {
		User existing = getUserById(uid);
		
		existing.setName(usr.getName());
		return repo.save(existing);
		
	}
	
	public User updateUserpartial(Integer uid,User usr) {
		User existing = getUserById(uid);
		
		existing.setName(usr.getName()!=null?usr.getName():existing.getName());
		existing.setPasswrod(usr.getPasswrod()!=null?usr.getPasswrod():existing.getPasswrod());
		return repo.save(existing);
		
	}
	
	public User getUserByName(String name) {
		User existing = repo.findByName(name);
		return existing;
	}
	
	
	
	public String deleteUser(Integer uid) {
		 repo.deleteById(uid);
		 return "User Deleted Succefully";
	}
}
