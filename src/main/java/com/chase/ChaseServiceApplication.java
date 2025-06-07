package com.chase;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class ChaseServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChaseServiceApplication.class, args);
	}
	
	
	public static void  addNumbers() {
		// body 
		
	}

}
