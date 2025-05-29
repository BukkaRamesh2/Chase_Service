package com.chase.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chase.Test;
import com.chase.entity.Customer;
import com.chase.service.CustomerService;

@RestController 
@RequestMapping
public class CustomerController {
	
	
	@Autowired
	CustomerService custService; // 
	
	
	public static void main(String[] args) {
		Test t = new Test();  // if your object is created you are cabale o0f reading all the memebers and methods 
		t.test();
		t.displayUser();
		t.addUser();
		
	}
	
	@PostMapping
	public Customer addCustomer(Customer customer) {
		return custService.addCustomer(customer);
	}
	
	@GetMapping
	public Customer getCustomer(Long customerId){
		return custService.getCustomer(customerId);
	}
	
	@GetMapping
	public List<Customer> getAllCustomers(){
		return custService.getAllCustomers();
	}
	
	@PutMapping
	public Customer updateCustomer(Customer customer){
		return custService.updateCustomer(customer);
	}
	
	@DeleteMapping
	public Customer deleteCustomer(Long customerId){
		return custService.deleteCustomer(customerId);
	}
	

}
