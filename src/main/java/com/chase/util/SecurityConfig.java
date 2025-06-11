package com.chase.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Autowired
	JwtFilter jwtFilter;
	
	
	@Bean
	public SecurityFilterChain  filterChain(HttpSecurity http) throws Exception{
		http.csrf().disable()
		.authorizeHttpRequests()
		.requestMatchers("/customer/login",
				"swagger-ui/index.html",
				"swagger-ui/**",
				"swagger-ui/index.html#/customer-controller/**",
				"/h2-console/login.jsp/**",
				"/h2-console/login.do?jsessionid/**",
				"/h2-console/test.do?jsessionid/**",
				"/customer/**").permitAll()
		.anyRequest().authenticated()
		.and()
		.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
		
		return http.build();
	}
	
	

}
