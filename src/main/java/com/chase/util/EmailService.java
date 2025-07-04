package com.chase.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class EmailService {

	public static Logger logger = LoggerFactory.getLogger(EmailService.class);

	@Async("taskExecutor")
	public void sendWelcomeMail(String name, String email) {

		try {
			logger.info("sending welcome email to :" + name + "at :" + email);
			Thread.sleep(3000);
			logger.info("email sent to :" + name + "at :" + email);
		} catch (InterruptedException e) {
			logger.error("email sending got an exception:");
			Thread.currentThread().interrupt();
		}

	}
}
