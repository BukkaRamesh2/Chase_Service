package com.chase.TransactionRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chase.entity.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction,Long>{

}
