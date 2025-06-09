package com.chase.util;

public class fraudchecktask implements Runnable{
	public String cardemail = "";
	

	public fraudchecktask(String loanemail, String cardemail) {
		super();
		this.cardemail = cardemail;
	}


	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			System.out.println("sending welcome cardemail:hello" + cardemail);
			Thread.sleep(3000);
			System.out.println("cardemail send to " +cardemail);
		}
		catch(InterruptedException e) {
			System.out.println("cardemail sending got an exception:");
			Thread.currentThread().interrupt();		
			}
		
	}

}
