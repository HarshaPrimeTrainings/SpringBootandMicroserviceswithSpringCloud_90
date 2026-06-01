package com.training.thymleafbootcampapp.model;

public class Particepant {
	
	private Integer pid;
	private String name;
	private String email;
	private String contact;
	
	
	public Particepant(Integer pid, String name, String email, String contact) {
		super();
		this.pid = pid;
		this.name = name;
		this.email = email;
		this.contact = contact;
	}
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	
	
	

}
