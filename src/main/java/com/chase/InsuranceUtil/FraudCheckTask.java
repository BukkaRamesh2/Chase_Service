package com.chase.InsuranceUtil;

public class FraudCheckTask implements Runnable{
	
public final String insuranceemail;
	

	public FraudCheckTask(String insuranceemail) {
		super();
		this.insuranceemail = insuranceemail;
	}


	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			System.out.println("sending welcome insuranceemail:hello" + insuranceemail);
			Thread.sleep(3000);
			System.out.println("insuranceemail send to " +insuranceemail);
		}
		catch(InterruptedException e) {
			System.out.println("insuranceemail sending got an exception:");
			Thread.currentThread().interrupt();		
			}
		
	}


}
