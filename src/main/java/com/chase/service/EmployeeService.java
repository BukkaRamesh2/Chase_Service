package com.chase.service;

import java.util.List;

import com.chase.entity.Employee;

public interface EmployeeService {
	public Employee addEmployee(Employee employee);
	public Employee getEmployee(long empId);
	public List<Employee> getAllEmployees();
	public Employee updateEmployee(Employee employee);
	public Employee deleteEmployee(int empId);

}
