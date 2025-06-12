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
		.requestMatchers(
				    "/login",
		            "/swagger-ui/**",
		            "/api-docs/**",
		            "/h2-console/**")
		.permitAll()
		.anyRequest().authenticated()
		.and()
		.headers().frameOptions().disable() //for connecting h2 console
		.and()
		.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
		
		return http.build();
	}
	
	

}