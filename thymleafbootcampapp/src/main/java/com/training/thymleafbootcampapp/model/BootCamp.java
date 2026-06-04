package com.training.thymleafbootcampapp.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class BootCamp {

	private Integer bid;
	private String topic;
	private LocalDate date;
	private List<Particepant> particepants = new ArrayList<>();
	
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

	public List<Particepant> getParticepants() {
		return particepants;
	}

	public void setParticepants(List<Particepant> particepants) {
		this.particepants = particepants;
	}
	
	
}
