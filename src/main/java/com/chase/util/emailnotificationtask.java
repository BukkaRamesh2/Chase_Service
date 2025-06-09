package com.chase.util;

public class emailnotificationtask implements Runnable {

	private final String Cardtype;
	private final String Cardemail;
	
	
	public emailnotificationtask(String cardtype, String cardemail) {
		super();
		this.Cardtype = cardtype;
		this.Cardemail = cardemail;
	}


	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			System.out.println("sending welcome cardtype to :" + Cardtype +" email:" + Cardemail);
			Thread.sleep(3000);
			System.out.println("cardtype send to "+ Cardtype +" at" +Cardemail);
		}
		catch(InterruptedException e) {
			System.out.println("cardtype sending got an exception:");
			Thread.currentThread().interrupt();		
			}
		
	}


	public String getCardtype() {
		return Cardtype;
	}


	public String getCardemail() {
		return Cardemail;
	}
}
