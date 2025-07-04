package com.chase.util;

public class FraudCheckTask implements Runnable {
	
	private final String email;

	

	public FraudCheckTask(String email) {
		super();
		this.email = email;
	}



	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			System.out.println("Starting  Fraud check:" + email);
			Thread.sleep(10000);
			System.out.println("Completed fraud check for:" +email);
		}
		catch(InterruptedException e) {
			System.out.println("fraud check got an exception:");
			Thread.currentThread().interrupt();		
			}
		
	}

}
