package com.chase.service;


import com.chase.entity.Employee;
import com.chase.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

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
            return employeeRepository.save(employee);
        }

        return null;
    }

    @Override
    public Employee getEmployee(Long empId) {
        if (empId != null && empId > 0) {
            System.out.println("Searching for employee with ID: " + empId);
            return employeeRepository.findById(empId).orElseGet(() -> {
                System.out.println("Employee not found.");
                return null;
            });
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
            for (Employee emp : employees) {
                if (emp.isStatus()) {
                    System.out.println("Active Employee: " + emp.getFirstName() + " " + emp.getLastName());
                } else {
                    System.out.println("Inactive Employee: " + emp.getFirstName() + " " + emp.getLastName());
                }
            }
        }

        return employees;
    }


	
	@Override
	public Employee updateEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Employee deleteEmployee(int empId) {
		// TODO Auto-generated method stub
		return null;
	}

}
