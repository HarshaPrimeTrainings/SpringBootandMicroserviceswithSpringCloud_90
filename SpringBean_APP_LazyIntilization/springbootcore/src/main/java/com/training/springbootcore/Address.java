package com.training.springbootcore;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Lazy
@Component
public class Address {

	private String state;
	private String city;
	private String zipcode;
	
	public Address() {
		System.out.println("Address Constructor");
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
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	@Override
	public String toString() {
		return "Address [state=" + state + ", city=" + city + ", zipcode=" + zipcode + "]";
	}
	
	
	
}
