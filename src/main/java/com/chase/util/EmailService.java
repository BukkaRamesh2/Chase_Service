package com.chase.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;



/*
 * 
 *  log 4j 
 *  slf 4j
 * 
 */

@Component
public class EmailService {
	
    private static final Logger logger = LoggerFactory.getLogger(EmailService.class);
	
    @Async("taskExecutor")
	public void sendWelcomeEmail(String name, String email) {
		try {

			logger.info("Sennding welcomne email to: " + name + "at : "+email);
			Thread.sleep(10000);// delay

			logger.info("SEmail sent to:  " + name + "at : "+email);
		} catch (InterruptedException e) {
			logger.error("Email sending got an excpetion : ");
			Thread.currentThread().interrupt();

		}
		
	}
	

}
