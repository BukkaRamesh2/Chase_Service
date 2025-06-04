package com.chase.service;


import com.chase.entity.Employee;

import com.chase.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;
    
    private List<Employee> employeeCache = new ArrayList<>();
    private Set<Long> highsalariedempId = new HashSet<>();
    private Map<Long, Employee> employeeMap = new HashMap<>();


    @Override
    public Employee addEmployee(Employee employee) {
        if (employee.getFirstName() == null || employee.getLastName() == null) {
            System.out.println("Employee name is missing.");
        } else {
            switch (employee.getGender().toLowerCase()) {
                case "male":
                    System.out.println("Welcome Mr. " + employee.getFirstName());
                    break;
                case "female":
                    System.out.println("Welcome Ms. " + employee.getFirstName());
                    break;
                default:
                    System.out.println("Welcome " + employee.getFirstName());
                    break;
            }

            employee.setStatus(true);
            Employee saved = employeeRepository.save(employee);
            
            //add to collection 
            //Adds the employee to the cache, the map, and if the salary is high, to the set of rich employee IDs.
            employeeCache.add(saved);
            employeeMap.put(saved.getEmployeeId(), saved);
            if (saved.getSalary() != null && saved.getSalary() > 100000) {
                highsalariedempId.add(saved.getEmployeeId());
            }

            return saved;
        }
        

        return null;
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
    	
    	if (empId != null && empId > 0) {
            System.out.println("Searching for employee with ID: " + empId);

            // Try from map first
            if (employeeMap.containsKey(empId)) {
                System.out.println("Found in cache");
                return employeeMap.get(empId);
            }

            // Fallback to DB
            Employee employee = employeeRepository.findById(empId).orElse(null);
            if (employee != null) {
                employeeCache.add(employee);
                employeeMap.put(empId, employee);
            } else {
                System.out.println("Employee not found.");
            }
            return employee;
        } else {
            System.out.println("Invalid employee ID.");
        }
        return null;
    }


    @Override
    public List<Employee> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        if (employees.isEmpty()) {
            System.out.println("No employees found in the system.");
        } else {
        	
        	//Logs each employee's status.
            for (Employee emp : employees) {
                if (emp.isStatus()) {
                    System.out.println("Active Employee: " + emp.getFirstName() + " " + emp.getLastName());
                } else {
                    System.out.println("Inactive Employee: " + emp.getFirstName() + " " + emp.getLastName());
                }
                
             // Add to collections
                employeeMap.put(emp.getEmployeeId(), emp);
                employeeCache.add(emp);
                if (emp.getSalary() != null && emp.getSalary() > 100000) {
                    highsalariedempId.add(emp.getEmployeeId());
                }
            }
        }

        return employees;
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

            System.out.println("Deleted employee with ID: " + empId);
            return null;
        } else {
            System.out.println("Employee ID invalid or not found.");
        }
        return null;
    }
		

}
