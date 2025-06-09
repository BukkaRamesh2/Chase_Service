package com.chase.util;

public class emailnotificationtask implements Runnable {

	private final String loantype;
	private final String loanemail;
	
	
	public emailnotificationtask(String loantype, String loanemail) {
		super();
		this.loantype = loantype;
		this.loanemail = loanemail;
	}


	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			System.out.println("sending welcome loantype to :" + loantype +" email:" + loanemail);
			Thread.sleep(3000);
			System.out.println("loantype send to "+ loantype +" at" +loanemail);
		}
		catch(InterruptedException e) {
			System.out.println("loantype sending got an exception:");
			Thread.currentThread().interrupt();		
			}
		
	}
}
