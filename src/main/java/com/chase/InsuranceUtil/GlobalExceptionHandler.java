package com.chase.InsuranceUtil;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(InsuranceNotFoundException.class)
	public String LoanNotFoundException(InsuranceNotFoundException ex) {
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
