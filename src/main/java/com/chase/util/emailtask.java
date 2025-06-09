package com.chase.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class emailtask {
	
	private static final Logger logger = LoggerFactory.getLogger(emailtask.class);
	
   @Async("taskExecutor")
	public void sendWelcomeMail(String cardtype, String cardemail) {
		// TODO Auto-generated method stub
		try {
			logger.info("in emailtask class sending welcome cardtype to :" + cardtype +" email:" + cardemail);
			Thread.sleep(3000);
			logger.info(" in email task cardtype send to "+ cardtype +" at" +cardemail);
		}
		catch(InterruptedException e) {
			logger.info("loantype sending got an exception:");
			Thread.currentThread().interrupt();		
			}
		
	}

}
