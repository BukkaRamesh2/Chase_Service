package com.chase.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chase.entity.Employee;
import com.chase.service.EmployeeService;

@RestController
@RequestMapping
public class EmployeeController {

	public EmployeeController() {
		// TODO Auto-generated constructor stub
	}

	@Autowired
	EmployeeService employeeService;

	@PostMapping
	public Employee addEmployee(Employee employee) {

		return employeeService.addEmployee(employee);

	}

	@GetMapping
	public Employee getEmployee(long empId) {

		return employeeService.getEmployee(empId);
	}
    
	@GetMapping
	public List<Employee> getAllEmployees() {
		return null;

	}

	@PutMapping
	public Employee updateEmployee(Employee employee) {

		return employeeService.updateEmployee(employee);
	}
    
	@DeleteMapping
	public Employee deleteEmployee(int empId) {
		return employeeService.deleteEmployee(empId);
	}

}
