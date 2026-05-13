package org.training.springbootcore;

import org.springframework.stereotype.Component;

@Component
public class Product {

	private Integer pid;
	private String catagery;
	private Integer price;
	
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	public String getCatagery() {
		return catagery;
	}
	public void setCatagery(String catagery) {
		this.catagery = catagery;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Product [pid=" + pid + ", catagery=" + catagery + ", price=" + price + "]";
	}
	
	
}
