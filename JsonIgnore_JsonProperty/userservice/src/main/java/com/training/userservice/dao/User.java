package com.training.userservice.dao;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

public class User {

	private Integer uid;
	private String name;
	private String contact;
	private String addr;
	
	//@JsonIgnore Completly Avoid the feild from serilization (Req & Resp)
	@JsonProperty(access = Access.WRITE_ONLY) // Exclude from Res (only set)
	//@JsonProperty(access = Access.READ_ONLY) // Exclude Request (only get)
	private String passwrod;
	
		
	public User(Integer uid, String name, String contact, String addr) {
		this.uid = uid;
		this.name = name;
		this.contact = contact;
		this.addr = addr;
	}
	
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
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}

	
	public String getPasswrod() {
		return passwrod;
	}

	public void setPasswrod(String passwrod) {
		this.passwrod = passwrod;
	}
	
	
	
}
