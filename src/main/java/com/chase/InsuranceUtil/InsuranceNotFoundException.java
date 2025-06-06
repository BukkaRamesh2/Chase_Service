package com.chase.InsuranceUtil;

public class InsuranceNotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7337443412571099520L;
	
	public InsuranceNotFoundException(String message) {
		super(message);
		System.out.println("Exception message is " + message);
	}

}
