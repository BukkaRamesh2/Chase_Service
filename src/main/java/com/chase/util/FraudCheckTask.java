package com.chase.util;

public class FraudCheckTask implements Runnable {
	
	private final double balance;

	public FraudCheckTask(double balance) {
		this.balance=balance;
	}

	@Override
	public void run() {
		try {
			System.out.println("Starting fraud check: "+ balance);
			Thread.sleep(50000);
			System.out.println("Completed fraud check: ");
			
		}catch(Exception e){
			System.out.println("Fraud Check got an exception");
			Thread.currentThread().interrupt();
		}
		
		
	}

}
