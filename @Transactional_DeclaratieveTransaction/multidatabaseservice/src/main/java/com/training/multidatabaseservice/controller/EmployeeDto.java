package com.training.multidatabaseservice.controller;

public class EmployeeDto {

	private String name;
	private String contact;
	private Integer aid;
	private AdressDto addr;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public Integer getAid() {
		return aid;
	}
	public void setAid(Integer aid) {
		this.aid = aid;
	}
	public AdressDto getAddr() {
		return addr;
	}
	public void setAddr(AdressDto addr) {
		this.addr = addr;
	}
	
	
	
}
