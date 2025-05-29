package com.chase.utils;

public class RoutingNumberValidator implements Validator{

	@Override
	public boolean isValid(String input) {
		return input != null && input.matches("\\d{9}");
	}

}
