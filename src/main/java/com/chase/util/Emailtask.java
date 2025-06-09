package com.chase.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class Emailtask {
	
	private static final Logger logger = LoggerFactory.getLogger(Emailtask.class);
	
   @Async("taskExecutor")
	public void sendWelcomeMail(String branchtype, String branchemail) {
		// TODO Auto-generated method stub
		try {
			logger.info("in emailtask class sending welcome branchtype to :" + branchtype +" email:" + branchemail);
			Thread.sleep(3000);
			logger.info(" in email task branchtype send to "+ branchtype +" at" +branchemail);
		}
		catch(InterruptedException e) {
			logger.info("branchtype sending got an exception:");
			Thread.currentThread().interrupt();		
			}
		
	}

}
