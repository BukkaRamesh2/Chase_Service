package com.chase.util;

public class EmailNotificationTask implements Runnable {
	
	private final String name ;
	private final String email;
	

	public EmailNotificationTask(String name, String email) {
		super();
		this.name = name;
		this.email = email;
	}





	@Override
	public void run() {
		
		try {
			System.out.println("sending welcome email to :" + name +"at :"+ email);
			Thread.sleep(3000);
			System.out.println("email sent to :" + name  + "at :"+ email);
		}
		catch(InterruptedException e) {
			System.out.println("email sending got an exception:");
			Thread.currentThread().interrupt();		
			}
		
	}
	
}