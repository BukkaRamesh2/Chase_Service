package com.chase.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class globalexceptionhandler {

	@ExceptionHandler(branchnotfoundexception.class)
	public String cardnotfoundexception(branchnotfoundexception ex) {
        return ex.getMessage();
    }
	
	@ExceptionHandler(IllegalArgumentException.class)
	public static ResponseEntity<String> IllegalArgumentException(IllegalArgumentException ex) {
        return new ResponseEntity<>("Bad Request "+ ex.getMessage(),HttpStatus.BAD_REQUEST);
    }
	
	@ExceptionHandler(ArithmeticException.class)
	public ResponseEntity<String> ArithmeticException(ArithmeticException ex) {
        return new ResponseEntity<>("Wrong Formula "+ ex.getMessage(),HttpStatus.METHOD_FAILURE);
    }
	
	
	
}