package com.chase.transactionController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chase.TransactionService.TransactionService;
import com.chase.entity.Transaction;

@RestController
@RequestMapping
public class TransactionController {

	 @Autowired
	    private TransactionService transactionService;

	    @PostMapping
	    public Transaction createTransaction( Transaction transaction) {
	        return transactionService.createTransaction(transaction);
	    }

	    @GetMapping
	    public Transaction getTransactionById( int id) {
	        return transactionService.getTransactionById(id);
	    }

	    @GetMapping
	    public List<Transaction> getAllTransactions() {
	        return transactionService.getAllTransactions();
	    }

	    @PutMapping
	    public Transaction updateTransaction( int id,  Transaction transaction) {
	        return transactionService.updateTransaction(id, transaction);
	    }

	    @DeleteMapping
	    public void deleteTransaction( int id) {
	        transactionService.deleteTransaction(id);
	    }
	
	
	
}
