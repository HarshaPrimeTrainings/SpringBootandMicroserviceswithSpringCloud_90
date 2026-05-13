package com.training.springbootcore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


@Component
public class User {
	
	private Integer uid;
	private String name;
	
	//feild injection (eager)
	//@Autowired
	private Address addr;
	
	User(){
		System.out.println("=======User Constructor");
	}
	
	// constructor injeciton
	//@Autowired
	User(Address addr){
		System.out.println("=======Argument Constructor");
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
	public Address getAddr() {
		return addr;
	}
	
	//setter injection (lazy)
	//@Autowired
	public void setAddr(Address addr) {
		this.addr = addr;
	}
	
	@Override
	public String toString() {
		return "User [uid=" + uid + ", name=" + name + ", addr=" + addr + "]";
	}
	
	
	

}
