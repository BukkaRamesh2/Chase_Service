package com.chase.reposiroty;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.chase.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>{

}
