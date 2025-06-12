package com.chase.service;

import com.chase.entity.Employee;


import com.chase.repository.EmployeeRepository;
import com.chase.util.EmailNotificationTask;
import com.chase.util.EmailService;
import com.chase.util.EmployeeEmailComparator;
import com.chase.util.EmployeeNotFoundException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;
	
	@Autowired
	EmailService emailService;

	private List<Employee> employeeCache = new ArrayList<>();
	private Set<Long> highsalariedempId = new HashSet<>();
	private Map<Long, Employee> employeeMap = new HashMap<>();

	private static final Logger logger = LoggerFactory.getLogger(EmployeeServiceImpl.class);
	private final ExecutorService executorService = Executors.newFixedThreadPool(2);

	@Override
	public Employee addEmployee(Employee employee) {
		
		//this will trigger Asynchronus task
		 emailService.sendWelcomeMail(employee.getFirstName(), employee.getEmail());
				
		
		if (employee.getFirstName() == null || employee.getLastName() == null) {
			logger.warn("Employee name is missing.");
		}

		switch (employee.getGender().toLowerCase()) {
		case "male":
			logger.info("Welcome Mr. {}" + employee.getFirstName());
			break;
		case "female":
			logger.info("Welcome Ms.{} " + employee.getFirstName());
			break;
		default:
			logger.info("Welcome {}" + employee.getFirstName());
			break;
		}

		employee.setStatus(true);
		Employee saved = employeeRepository.save(employee);

		// if email is null and email does not contain @ invalid format ;
		if (employee.getEmail() == null || !employee.getEmail().contains("@")) {
			logger.error("Loan having invalid emial format");
			throw new EmployeeNotFoundException("Employee having invalid email format ot emial is null");
		}

		//Runnable emailTask = new EmailNotificationTask(employee.getEmail(), employee.getFirstName());
		//new Thread(emailTask).start();
		
		
		
		return saved;
	}

	@Override
	public Employee getEmployee(Long empId) {
//        if (empId != null && empId > 0) {
//            System.out.println("Searching for employee with ID: " + empId);
//            return employeeRepository.findById(empId).orElseGet(() -> {
//                System.out.println("Employee not found.");
//                return null;
//            });
//        } else {
//            System.out.println("Invalid employee ID.");
//        }
//        return null;
//    }

		/*
		 * if (empId == null || empId <= 0) { throw new
		 * IllegalArgumentException("Invalid employee ID."); }
		 * 
		 * if (employeeMap.containsKey(empId)) { return employeeMap.get(empId); }
		 * 
		 * Employee employee = employeeRepository.findById(empId) .orElseThrow(() -> new
		 * EmployeeNotFoundException("Employee with ID " + empId + " not found."));
		 * 
		 * employeeCache.add(employee); employeeMap.put(empId, employee); return
		 * employee;
		 * 
		 */
		if (empId.SIZE > 0) {
			// get employee
			System.out.println("Employee is havning length > 0");
			return employeeRepository.findById(empId).orElse(null); //
		} else {
			throw new EmployeeNotFoundException("The Employee is not found with id:");
			// System.out.println("Please send a valid input with min length ");
			// return null;
		}

		// return null;

	}

	@Override
	public List<Employee> getAllEmployees() {

		List<Employee> employees = employeeRepository.findAll(); // [alex, box, clawk]

		// using map get data group by email
		Map<String, List<Employee>> hashMap = new HashMap<>();
		Map<String, List<Employee>> linkedHashMap = new LinkedHashMap<>();
		Map<String, List<Employee>> treeMap = new TreeMap<>();

		// iterate trough Employee using for each

		for (int i = 0; i < employees.size(); i++) {
			employees.get(i);// alex
		}

		for (Employee e : employees) {

			String domain = e.getEmail().split("@")[1]; // alex@gmail.com

			hashMap.computeIfAbsent(domain, k -> new ArrayList<>()).add(e); /// get customer and add to hasmap

			linkedHashMap.computeIfAbsent(domain, k -> new ArrayList<>()).add(e); /// get customer and add to hasmap

			treeMap.computeIfAbsent(domain, k -> new ArrayList<>()).add(e); /// get customer and add to hasmap

		}

		System.out.println("HashMap (unordered)" + hashMap.keySet());

		System.out.println("linkedHashMap (inserrion)" + hashMap.keySet());

		System.out.println("treeMap (natural sorting)" + hashMap.keySet());
		
		

		List<Employee> employee = employeeRepository.findAll();
		if (employee.isEmpty()) {
			logger.info("No employees found in the system.");
		} else {

			// Logs each employee's status.
			for (Employee emp : employee) {
				if (emp.isStatus()) {
					logger.info("Active Employee: " + emp.getFirstName() + " " + emp.getLastName());
				} else {
					logger.info("Inactive Employee: " + emp.getFirstName() + " " + emp.getLastName());
				}

				// Add to collections
				employeeMap.put(emp.getEmployeeId(), emp);
				employeeCache.add(emp);
				if (emp.getSalary() != null && emp.getSalary() > 100000) {
					highsalariedempId.add(emp.getEmployeeId());
				}
			}
			
			//Collections.sort(employee);// sort by firstname
			employees.sort(new EmployeeEmailComparator()); //this will sort by email
			
		
		}

		return employee;
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		// TODO Auto-generated method stub
		if (employee.getEmployeeId() == null || !employeeRepository.existsById(employee.getEmployeeId())) {
			System.out.println("Employee does not exist.");
			return null;
		}

		Employee updated = employeeRepository.save(employee);

		// Update collections
		employeeMap.put(updated.getEmployeeId(), updated);
		employeeCache.removeIf(e -> e.getEmployeeId().equals(updated.getEmployeeId()));
		employeeCache.add(updated);

		if (updated.getSalary() != null && updated.getSalary() > 100000) {
			highsalariedempId.add(updated.getEmployeeId());
		} else {
			highsalariedempId.remove(updated.getEmployeeId());
		}

		return updated;
	}

	@Override
	public Employee deleteEmployee(Long empId) {
		// TODO Auto-generated method stub
		if (empId != null && employeeRepository.existsById(empId)) {
			employeeRepository.deleteById(empId);

			// Remove from collections
			employeeMap.remove(empId);
			employeeCache.removeIf(e -> e.getEmployeeId().equals(empId));
			highsalariedempId.remove(empId);

			logger.info("Deleted employee with ID: " + empId);
			return null;
		} else {
			System.out.println("Employee ID invalid or not found.");
		}
		return null;
	}

}
