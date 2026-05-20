package com.training.springbootcore.model;

import org.springframework.stereotype.Component;

@Component
public class Order {

	private int oid;
	private String status;
	public int getOid() {
		return oid;
	}
	public void setOid(int oid) {
		this.oid = oid;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Order [oid=" + oid + ", status=" + status + "]";
	}
	
	
}
