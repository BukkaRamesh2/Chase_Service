package com.chase.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chase.entity.Customer;
import com.chase.service.CustomerService;
import com.chase.util.FraudCheckTask;
import com.chase.util.JwtUtil;

@RestController 
@RequestMapping("/customer") 
public class CustomerController {
	
	
	@Autowired
	CustomerService custService; // 
	
	
	public static void main(String[] args) {
//		Test t = new Test();  // if your object is created you are cabale o0f reading all the memebers and methods 
//		t.test();
//		t.displayUser();
//		t.addUser();
		
		
		
		/*     
		 * 
		 *  GET  -- fetch dataa from database
		 *  PUT  -- update the exisitng record // it will create a new record 
		 *  POST   --- it will always create new record
		 *  DELETE   -- delete the record from database
		 *  
		 * 
		 *   http://www.chase_servce.com/addCustomer   -- POST Mapping 
		 *   
		 *   Headers -- auth
		 *   request /  body   
		 *   response 
		 *   
		 *   customer 
		 *   {
		 *     "id" : "1" , 
				firstName : "Alex" ,
				lastName: "Alex",
			   address: "Alex",
			   email: "Alex",
			   mobileNumber: "Alex", 
			   status: "Alex",
			   fullName: "Alex",
			    gender: "Alex"
		 *   
		 *   }
		 *   
		 *   
		 *   response : the customer added succefully 
		 *   
		 *   
		 *   
		 *   
		 *   RequestParam and PathVaraible 
		 *   
		 *   
		 *    
		 *   http://www.chase_servce.com/customer/getCustomer/{1}  -- Get Mapping
		 *   
		 *   http://www.chase_servce.com/customer/getCustomer?customerId=1  -- Get Mapping
		 *   
		 *   http://www.chase_servce.com/customer/getAllCustomers   -- Get Mapping
		 *   
		 *   http://www.chase_servce.com/customer/updateCustomer   -- Put Mapping
		 *    customer 
		 *   {
		 *     "id" : "1" , 
				firstName : "Alex" ,
				lastName: "Alex",
			   address: "tx",
			   email: "Alex",
			   mobileNumber: "Alex", 
			   status: "Alex",
			   fullName: "Alex",
			    gender: "Alex"
		 *   
		 *   }
		 *   
		 *   http://www.chase_servce.com/deleteCustomer/{1}   -- delete Mapping 
		 * 
		 *  test
		 *  
		 *  Authentication --  JWT token, Spring Security, Basic Auth oAuth, Role based access 
		 *  Authorization -- What all the access are provided to users
		 *  
		 *  
		 *  User X, Y, Z
		 *  Role  --A, B, C
		 *  User-Role
		 *  X-A
		 *  Y-B
		 *  Z-A,C
		 *  
		 *  how to integrate any component 
		 *  DI
		 *  
		 *  @Component 
		 *  
		 *  Add Dependency in POM 
		 *  
		 *  
		 *  JWT 
		 *  Get the library from Maven ccentreal REPO 
		 *  
		 * 
		 * 
		 */
		
	}
	
	@Autowired
	JwtUtil jwtUtil;
	
	@PostMapping("/login")
	public String login(@RequestParam String username, @RequestParam String password) {
		if("admin".equals(username) && "admin123".equals(password)) {
			return jwtUtil.generateToken(username);
			
		} else {
			throw new RuntimeException("Invalid Credentails");
		}
	}
	
	@PostMapping("/addCustomer")    //
	public Customer addCustomer(@RequestBody Customer customer) {
		// kick off fraud check	
        Runnable fraudCheckTask = new FraudCheckTask(customer.getEmail()); 
		new Thread(fraudCheckTask).start();  // thread will initate 
		 // porocced with actual logic to svae the data
		return custService.addCustomer(customer);
	}
	
	@GetMapping("/getCustomer/{id}")
	public Customer getCustomer(@PathVariable  Long customerId){
		return custService.getCustomer(customerId);
	}
	
	@GetMapping("/getAllCustomers")
	public List<Customer> getAllCustomers(){
		return custService.getAllCustomers();
	}
	
	@PutMapping("/updateCustomer")
	public Customer updateCustomer(@RequestBody  Customer customer){
		return custService.updateCustomer(customer);
	}
	
	@DeleteMapping("/deleteCustomer/{id}")
	public void deleteCustomer( Long customerId){
		 custService.deleteCustomer(customerId);
	}
	

}
