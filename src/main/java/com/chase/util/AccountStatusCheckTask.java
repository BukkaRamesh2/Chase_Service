package com.chase.util;

public class AccountStatusCheckTask implements Runnable {
	
	private final long accountId;
	private final boolean isActive;

	public AccountStatusCheckTask(long accountId, boolean isActive) {
		super();
		this.accountId = accountId;
		this.isActive = isActive;
	}



	@Override
	public void run() {
		try {
			System.out.println("Starting check. Status is: "+isActive+ "for account: "+accountId);
			Thread.sleep(5000);
			System.out.println("Completed check ");
			
		}catch(InterruptedException e){
			System.out.println("Status Check got an exception");
			Thread.currentThread().interrupt();
		}
		
		
	}

}
