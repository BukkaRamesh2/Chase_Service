package com.chase.util;

public class CustomerNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 5957342967839838457L;

	public CustomerNotFoundException() {
		// TODO Auto-generated constructor stub
	}
	
	 public CustomerNotFoundException(String message) {
	        super(message);
	    }

	 
	 public CustomerNotFoundException(String message, String code) {
	        //super(message,  code);
	    }

}
