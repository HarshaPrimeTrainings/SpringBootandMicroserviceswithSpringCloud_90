package com.training.userservice.dao;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer aid;
	private String state;
	private String city;
	
	//@Column(unique = true) -> from SpringBoot 4 @Column(unique = true) is optional by default in OnetoOne referencedColumn is unique
	private Integer zipcode;
	
	public Integer getAid() {
		return aid;
	}
	public void setAid(Integer aid) {
		this.aid = aid;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public Integer getZipcode() {
		return zipcode;
	}
	public void setZipcode(Integer zipcode) {
		this.zipcode = zipcode;
	}
	
	
}
