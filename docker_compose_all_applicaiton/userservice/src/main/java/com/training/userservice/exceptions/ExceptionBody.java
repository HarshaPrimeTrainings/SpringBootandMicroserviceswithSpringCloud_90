package com.training.userservice.exceptions;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class ExceptionBody {

	private LocalDateTime timestamp;
	private String message;
	private String status;
	
	
	public ExceptionBody(LocalDateTime timestamp, String message, String status) {
		super();
		this.timestamp = timestamp;
		this.message = message;
		this.status = status;
	}
	
	public LocalDateTime getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
}
