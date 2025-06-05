package com.chase.util;

public class EmailNotificationTask implements Runnable {

	private final String name;
	private final String email;
	
	

	public EmailNotificationTask(String name, String email) {
		super();
		this.name = name;
		this.email = email;
	}



	@Override
	public void run() {
		try {

			System.out.println("Sennding welcomne email to: " + name + "at : "+email);
			Thread.sleep(3000);// delay

			System.out.println("SEmail sent to:  " + name + "at : "+email);
		} catch (InterruptedException e) {
			System.out.println("Email sending got an excpetion : ");
			Thread.currentThread().interrupt();

		}
		
	}

}
