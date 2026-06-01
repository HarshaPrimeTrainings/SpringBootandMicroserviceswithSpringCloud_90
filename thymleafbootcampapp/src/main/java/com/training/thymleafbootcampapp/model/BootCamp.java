package com.training.thymleafbootcampapp.model;

import java.time.LocalDate;

public class BootCamp {

	private Integer bid;
	private String topic;
	private LocalDate date;
	
	
	public BootCamp(Integer bid, String topic, LocalDate date) {
		super();
		this.bid = bid;
		this.topic = topic;
		this.date = date;
	}
	
	public Integer getBid() {
		return bid;
	}
	public void setBid(Integer bid) {
		this.bid = bid;
	}
	public String getTopic() {
		return topic;
	}
	public void setTopic(String topic) {
		this.topic = topic;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	
	
}
