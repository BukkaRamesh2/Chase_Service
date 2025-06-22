package com.chase.service;

import java.util.List;

import com.chase.entity.Customer;
import com.chase.util.CustomerNotFoundException;

public interface CustomerService {
	
	public Customer addCustomer(Customer customer) throws CustomerNotFoundException;
	public Customer getCustomer(Long customerId);
	public List<Customer> getAllCustomers();
	public Customer updateCustomer(Customer customer);
	public void deleteCustomer(Long customerId);
	public String callPncService();
	public String callPncService1();
	

}
