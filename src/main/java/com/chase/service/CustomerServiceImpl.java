package com.chase.service;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chase.controller.CustomerController;
import com.chase.entity.Customer;
import com.chase.reposiroty.CustomerRepository;
import com.chase.util.CustomerEmailComparator;
import com.chase.util.CustomerNotFoundException;
import com.chase.util.EmailNotificationTask;
import com.chase.util.EmailService;

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
 *   Collections 
 *     List (Interface) -- IMplelemnts -- LinkedList, ArrayList, Stack / Vector   -- will always stores duplicate values
 *     Set -- HashSet, LinkedHahsSet, TressSet  no duplicates
 *     Map   -- HashMap, LinkedHashMap, TreeMap   -- key value pair 
 *     
 *     ArrayList -- internally users array [0] [1] 
 *     List<names> names = ArrayList<>();
 *     names.add("Alex");   // 0
 *     names.add("Bob");  // 1
 *     
 *    List<names> names = LinkedList<>();   // internally having three different memmory areas for single data
 *    names.add("Alex");   // 0
 *    names.add("Bob");  // 1000
 *    //999 -- update the customer name 
 *        
 *      [0|0|1] 3 mempory location   ---
 *      
 *      [0|1|2] 3 mempory location   -


		[1|2|3] 3 mempory location   -
		
		The modiofication of any data is faster 
		
		Set -- WOn't allow you to stroe duplicates
		
		Intenalling the set is using hashing mechanism 
		int hashcode --  
		boolean equals -- 
		
		
		
		private List<String> phoneNumbers;
		private Map<String, Double>  accountBalances;
		private Set<String> accountTypes;
		
		
		
 		
		
 *     
 *   Exception 
 *   
 *   Global Exception 
 *   
 *   
 *   
 *   Thread -- simple process 
 *   
 *   
 *   Thread  -- class   extends  inherit 
 *   Runnable  -- interface implement and inherit 
 *   
 *   
 *   500 
 *   
 *   states and life cycle 
 *   
 *   New -- create   start()
 *   Runnable -- it may be running   run()
 *   Blocked -- waiting  dfpr resouces to release   wait()  notify() // notifyAll()
 *   waiting -- wait   join()  sleep()
 *   Terminated -- stopped 
 *   
 *   
 *   
 *   
 * 
 */
@Service
public class CustomerServiceImpl implements CustomerService{
	
    private static final Logger logger = LoggerFactory.getLogger(CustomerServiceImpl.class);

	@Autowired
	CustomerRepository customerRepository; 
	
	@Autowired
	EmailService emailService;
	

	@Override
	public Customer addCustomer(Customer customer) {
		
		// this will trigger async task 
		emailService.sendWelcomeEmail(customer.getFirstName(), customer.getEmail()); 
		
		// arraylist linkedlist 
		// get currrent time in ns before
		// perform opermation in arraylist and linkedlist
		// get cuurent time after
		// diff = after - before 
		File file = new File("C:\test.txt");
		
		try {
		  
			
			
			file.getAbsolutePath();
			
		List<String> arrayList = new ArrayList<>(customer.getPhoneNumbers());
		List<String> LinkedList = new LinkedList<>(customer.getPhoneNumbers());
		
		
		
		long startArray = System.nanoTime();
		arrayList.add("Test-Array");
		arrayList.add("Test-Array");
		arrayList.add("Test-Array");
		long endArray = System.nanoTime();
		
		long startLinked = System.nanoTime();
		LinkedList.add("Test-Linked");
		LinkedList.add("Test-Linked");
		LinkedList.add("Test-Linked");
		long endLinked = System.nanoTime();
		
		logger.info("ArrayList operation time: " +(endArray - startArray) + "ns");
		System.out.println("LinkedList operation time: " +(endLinked - startLinked) + "ns");
		
		}catch(Exception e ) {
			e.printStackTrace(); /// 
		}finally {
			//close the file tghe always execute 
		}
		
		
		//if email is null  and email does not conatins @   in vvalid email format 
		if(customer.getEmail() == null || !customer.getEmail().contains("@") ) {
			System.out.println("Customer having invalid email format ");
			throw new IllegalArgumentException("Customer having invalid email format or the email address is null ");
		}
		
		Runnable emailTask = new EmailNotificationTask(customer.getEmail(), customer.getFirstName()); 
		new Thread(emailTask).start();  // thread will initate 
		
		
		
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
			throw new CustomerNotFoundException("The customer is not found with id:");
			//System.out.println("Please send a valid input with min length ");
			//return null;
		}
		
		
		
		//return null;
	
	}

	@Override
	public List<Customer> getAllCustomers() {
		// cusromerrepor you have method called findall
		// list of customer are empty throw exception 
		// cusomer get status if active then give only that list 
		
		List<Customer> customers = customerRepository.findAll();  // [alex, box, clawk]
		
		//using map get data group by email 
		Map<String, List<Customer>> hashMap = new HashMap<>();
		Map<String, List<Customer>> linkedHashMap = new LinkedHashMap<>();
		Map<String, List<Customer>> treeMap = new TreeMap<>();
		
		// iterate trough customers using for each 
		
		for(int i =0; i < customers.size(); i++) {
			customers.get(i);// alex
		}
		
		for(Customer c: customers) {
			
			String domain = c.getEmail().split("@")[1];  // alex@gmail.com
			
			hashMap.computeIfAbsent(domain, k -> new ArrayList<>()).add(c);     /// get customer and add to hasmap
			
			linkedHashMap.computeIfAbsent(domain, k -> new ArrayList<>()).add(c);     /// get customer and add to hasmap
			
			treeMap.computeIfAbsent(domain, k -> new ArrayList<>()).add(c);     /// get customer and add to hasmap
			
			
		}
		
		System.out.println("HashMap (unordered)" +hashMap.keySet());
		
		System.out.println("linkedHashMap (inserrion)" +hashMap.keySet());
		
		System.out.println("treeMap (natural sorting)" +hashMap.keySet());
		
		
		
		
		if(customers.isEmpty()) {
		    System.out.println(" there is no cusomers found");
		} else {
			customers.forEach(customer -> {
				if(customer.isStatus()) {
					System.out.println("All the customers returning are status active");
				}
			});
			Collections.sort(customers);  // sort by firstname
			customers.sort(new CustomerEmailComparator());  // sort by email
			return customers;
		}
		
		
		
		return null;
	}

	@Override
	public Customer updateCustomer(Customer customer) {
		// TODO Auto-generated method stub
		
		Optional<Customer> cust = customerRepository.findById(customer.getId());
		if(cust.isEmpty()) {
			throw new CustomerNotFoundException(" Customer is not found");
		}

		//set implementation
		//hashset   unordered
		//linkedhashset  preserve inseetion order
		//treeset  // natural dsorting
		
		// filter invaslid types 
		
		Set<String> rawSet = customer.getAccountTypes();
		rawSet.removeIf(type -> type == null || type.trim().isEmpty());
		
		Set<String> hashSet = new TreeSet<>(rawSet);
		
		System.out.println("Treeset: "+hashSet);
		
		
		
//		List<Customer> custList = new ArrayList<>();
//		// time taken to get 999 and update using arraylist  // 2
//		// is used foir insertion 
//		custList.add(new Customer("Alex"));
//		custList.add(new Customer("Alex"));
//		custList.add(new Customer("Alex"));
//		custList.add(new Customer("Alex"));
//		
//		
//		List<Customer> custList2 = new LinkedList<>();
//		// time taken to get 999 and update using Likedlist varies in min  // >1 <2
//		// maniopu;lations / updations 
//		
//		
//		Set<Customer> custList3 = new HashSet<>();
//		custList3.add(new Customer("Alex"));
//		custList3.add(new Customer("Alex"));
//		custList3.add(new Customer("Alex"));
//		custList3.add(new Customer("Alex"));
		
		return customerRepository.save(customer);
	}

	@Override
	public void deleteCustomer(Long customerId) {
		// TODO Auto-generated method stub
		 customerRepository.deleteById(customerId);
	}

}
