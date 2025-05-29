package com.chase.utils;

public class AccountIdValidator implements Validator{

	@Override
	public boolean isValid(String input) {
		return input != null && input.matches("\\d{10}");
	}
	
}
