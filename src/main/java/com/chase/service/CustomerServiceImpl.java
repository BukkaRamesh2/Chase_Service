package com.chase.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chase.controller.CustomerController;
import com.chase.entity.Customer;
import com.chase.reposiroty.CustomerRepository;

/*
 * 
 *   Service is Interface
 *   ServiceImpl is Class
 *   
 *   
 *   Class Extends Class  -- acquiring the properties of parent to child
 *   Class Implements Interface  -- 
 *   Interface Extends Interface -- 
 *   
 *   
 *   
 *   
 * 
 */
@Service
public class CustomerServiceImpl implements CustomerService{
	
	
	@Autowired
	CustomerRepository customerRepository;   
	

	@Override
	public Customer addCustomer(Customer customer) {
		//if email is null  and email does not conatins @   in vvalid email format 
		if(customer.getEmail() == null || !customer.getEmail().contains("@") ) {
			System.out.println("Customer having invalid email format ");
		}
		
		//using switch customer catgory is male or female
		switch(customer.getGender().toLowerCase()) {
		case "male":
			  System.out.println("adding  customer to male category");
			  break;
		case "female":
			  System.out.println("adding  customer to female category");
			  break;
		default:
			 System.out.println("adding customer to default category");
			 break;
		}
		
		
		return customerRepository.save(customer);
	}

	@Override
	public Customer getCustomer(Long customerId) {		
		if(customerId.SIZE > 0 ) {
			// get custiomer
			System.out.println("Customer is havning length > 0");
			return customerRepository.getById(customerId); // 
		} else
		{
			System.out.println("Please send a valid input with min length ");
		}
		
		
		
		return null;
	}

	@Override
	public List<Customer> getAllCustomers() {
		// cusromerrepor you have method called findall
		// list of customer are empty throw exception 
		// cusomer get status if active then give only that list 
		List<Customer> customers = customerRepository.findAll();
		if(customers.isEmpty()) {
		    System.out.println(" there is no cusomers found");
		} else {
			customers.forEach(customer -> {
				if(customer.isStatus()) {
					System.out.println("All the customers returning are status active");
				}
			});
			return customers;
		}
		
		
		
		return null;
	}

	@Override
	public Customer updateCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer deleteCustomer(Long customerId) {
		// TODO Auto-generated method stub
		return null;
	}

}
