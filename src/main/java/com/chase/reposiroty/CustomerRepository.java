package com.chase.reposiroty;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chase.entity.Customer;

public interface CustomerRepository extends JpaRepository<Long, Customer>{

}
