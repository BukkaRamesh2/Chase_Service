package com.chase.util;

public class AccountNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -6049135425972919656L;

	public AccountNotFoundException() {
	}
	
    public AccountNotFoundException(String message) {
        super(message);
    }

}
