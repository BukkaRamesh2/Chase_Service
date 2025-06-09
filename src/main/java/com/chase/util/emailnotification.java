package com.chase.util;

public class emailnotification implements Runnable {

	private final String Branchtype;
	private final String Branchemail;
	
	
	
	public emailnotification(String branchtype, String branchemail) {
		super();
		this.Branchtype = branchtype;
		this.Branchemail = branchemail;
	}


	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			System.out.println("sending welcome loantype to :" + Branchtype +" email:" + Branchemail);
			Thread.sleep(3000);
			System.out.println("loantype send to "+ Branchtype +" at" +Branchemail);
		}
		catch(InterruptedException e) {
			System.out.println("branchtype sending got an exception:");
			Thread.currentThread().interrupt();		
			}
		
	}
}
