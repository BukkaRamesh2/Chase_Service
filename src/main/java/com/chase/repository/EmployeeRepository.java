package com.chase.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RestController;

import com.chase.entity.Employee;


public interface EmployeeRepository extends JpaRepository<Employee,Long>{

}
