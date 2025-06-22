package com.chase.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebFluxConfig {

	
    @Autowired
    WebClient.Builder webClientBuilder;
    
	public WebFluxConfig() {
		// TODO Auto-generated constructor stub
	}
	
	
	@Bean
	public WebClient webClient() {
		
		
	    WebClient webClient = webClientBuilder.baseUrl("http://localhost:9093")
                .build();
		return webClient;
				
				
	}

}
