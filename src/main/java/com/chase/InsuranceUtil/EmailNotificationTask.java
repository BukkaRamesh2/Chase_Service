package com.chase.InsuranceUtil;

public class EmailNotificationTask implements Runnable{
	
	private final String insurancetype;
	private final String insuranceemail;
	
	
	public EmailNotificationTask(String insurancetype, String insuranceemail) {
		super();
		this.insurancetype = insurancetype;
		this.insuranceemail = insuranceemail;
	}


	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			System.out.println("sending welcome insurancetype to :" + insurancetype +" email:" + insuranceemail);
			Thread.sleep(3000);
			System.out.println("insurancetype send to "+ insurancetype +" at" +insuranceemail);
		}
		catch(InterruptedException e) {
			System.out.println("insurancetype sending got an exception:");
			Thread.currentThread().interrupt();		
			}
		
	}

}
