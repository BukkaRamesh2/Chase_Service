package com.chase.service;

import java.util.List;

import com.chase.entity.Customer;

public interface CustomerService {
	
	public Customer addCustomer(Customer customer);
	public Customer getCustomer(Long customerId);
	public List<Customer> getAllCustomers();
	public Customer updateCustomer(Customer customer);
	public Customer deleteCustomer(Long customerId);
	

}
