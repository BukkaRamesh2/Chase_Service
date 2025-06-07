package com.chase.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class AccountStatusCheckService {

	private static final Logger logger = LoggerFactory.getLogger(AccountStatusCheckService.class);
	
	@Async("taskExecutor")
	public void checkStatus(long accountId, boolean isActive) {
		try {
			logger.info("Starting check. Status is: "+isActive+ "for account: "+accountId);
			Thread.sleep(5000);
			logger.info("Completed check ");
			
		}catch(InterruptedException e){
			logger.error("Status Check got an exception");
			Thread.currentThread().interrupt();
		}
		
		
	}

}
