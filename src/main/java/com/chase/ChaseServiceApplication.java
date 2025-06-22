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
	
	
	
	
	/*
	 * 
	 *    Spring boot applicaiton with micro services
	 * 
	 *    We have a service chase service performaning CURD opearattions
	 *    \\\\
	 *    we have another spring boot app pnc service performing CURD operations
	 *    
	 *    to have a communication between service chase and PNC 
	 *    
	 *    localhost:8080/customer/getCustomers  -- chase
	 *    locahost:9090/employee/getEmployeees -- DCU 
	 *    
	 *    
	 *    
	 *    
	 *    
	 *    
	 *    1. REST Template -- simple structure
	 *    2. WebFlux -- Reactive programing and non blocking 
	 *    3. Messaging Queues    ---  publisher and subscriber  concept --- Active MQ, Rabbit MQ, Kafka 
	 *    --- Asynchronous ways of comminication 
	 *    
	 *    
	 *    
	 *    
	 *    
	 *    springframwwork.web library
	 *    
	 *    
	 *    Springboot starter webflux
	 *    
	 *    
	 *    
	 *    Error handling and retry mechanism 
	 *    
	 *    
	 *    Resilience4J
	 *     
	 *     
	 *     @retry name
	 *     fallbackMethod ""
	 *     @circuitbreaker name 
	 *     fallbackmethod
	 *    
	 *    
	 * 
	 *    Service Discovery -- will service is up and service down     eureka
	 *    API Gateway ---- singl;e server traverse aalll the calls    spring cloud gateway
	 *    Config Server  -- centralized property configs  Github 
	 *    Load Balancer  -- balances calls between multiple service nodes   AWS 
	 *    Fault Tolerance  -- retryies and fallbacks   Resilince4j
	 *    JWT  -- secure API endpoints  
	 *    
	 * 
	 * 
	 *     @EnableEurekaServer  -- spring boot parent class
	 *     
	 *     application.yml
	 *     
	 *     server.port  :  8761    --
	 *     eureka resgiter client 
	 * 
	 * 
	 *    1 server 
	 *    2 clinets 
	 *    
	 *    PNC 
	 *    Chase
	 *    
	 *    
	 *    Api Gateways 
	 *    
	 *    eureka clinet 
	 *    spring cloud libraries
	 *    
	 *    server port 8888
	 *    
	 *    sPING cloud config 
	 *    lb and url 
	 *    
	 *    
	 *    
	 *     localhost:8080/customer/getCustomers  -- chase
	 *    locahost:9090/employee/getEmployeees -- DCU 
	 *    
	 *    
	 *    
	 *    
	 *    
	 *    
	 * 
	 * 
	 */

}
