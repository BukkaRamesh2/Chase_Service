package com.chase.util;

public class fraudcheck implements Runnable{
	public final String branchemail;
	

	public fraudcheck(String branchemail) {
		super();
		this.branchemail = branchemail;
	}


	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			System.out.println("sending welcome branchemail:hello" + branchemail);
			Thread.sleep(3000);
			System.out.println("branchemail send to " +branchemail);
		}
		catch(InterruptedException e) {
			System.out.println("branchemail sending got an exception:");
			Thread.currentThread().interrupt();		
			}
		
	}

}
