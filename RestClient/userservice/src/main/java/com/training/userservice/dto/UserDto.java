package com.training.userservice.dto;

import java.util.List;

public class UserDto {

	private Integer uid;
	private String name;
	private String passwrod;
	private AddressDto addr;
	private List<OrderDto> orders;
	
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPasswrod() {
		return passwrod;
	}
	public void setPasswrod(String passwrod) {
		this.passwrod = passwrod;
	}
	public AddressDto getAddr() {
		return addr;
	}
	public void setAddr(AddressDto addr) {
		this.addr = addr;
	}
	public List<OrderDto> getOrders() {
		return orders;
	}
	public void setOrders(List<OrderDto> orders) {
		this.orders = orders;
	}
	
	
	
}
