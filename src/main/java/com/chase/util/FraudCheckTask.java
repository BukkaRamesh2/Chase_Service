package com.chase.util;

public class FraudCheckTask implements Runnable {

	private final String customerEmail;
	
	public FraudCheckTask(String customerEmail) {
		this.customerEmail =  customerEmail;
	}

	@Override
	public void run() {
		try {

			System.out.println("Starting fraud check: " + customerEmail);
			Thread.sleep(30000);// delay

			System.out.println("Completed fraud check for : " + customerEmail);
		} catch (InterruptedException e) {
			System.out.println("fraud check got an excpetion : ");
			Thread.currentThread().interrupt();

		}
	}
	

}
