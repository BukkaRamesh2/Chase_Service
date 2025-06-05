package com.chase.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	public GlobalExceptionHandler() {
		// TODO Auto-generated constructor stub
	}
	
	@ExceptionHandler(CustomerNotFoundException.class)
	public String CustomerNotFoundException(CustomerNotFoundException ex) {
		return ex.getMessage();
	}
	
	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<String> IllegalArgumentException(IllegalArgumentException ex) {
		return new ResponseEntity<>("Bad input / request been passed by the user: "+ex.getMessage(), HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(MyOwn.class)
	public ResponseEntity<String> MyOwn(MyOwn ex) {
		return new ResponseEntity<>("The user procced wrong forumla: "+ex.getMessage(), HttpStatus.METHOD_FAILURE);
	}

}
