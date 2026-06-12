package com.training.userservice.exceptions;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<Object> handleUserNotFound(UserNotFoundException ex){
		Map<String,Object> expbody = new HashMap<>();
		expbody.put("timestamp", LocalDateTime.now());
		expbody.put("message", "UNable to find user");
		return ResponseEntity.status(HttpStatus.NOT_FOUND)
				.body(expbody);
	}
	
}
