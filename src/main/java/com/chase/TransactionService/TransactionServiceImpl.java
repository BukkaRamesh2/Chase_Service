package com.chase.TransactionService;

import com.chase.TransactionRepository.TransactionRepository;
import com.chase.entity.Transaction;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionServiceImpl implements TransactionService {
	
	@Autowired
    TransactionRepository transactionRepository;
	

    private List<Transaction> transactionDatabase = new ArrayList<>();
    private static Long idCounter = 1L;

    // Create a new transaction with basic checks
    public Transaction createTransaction(Transaction transaction) {
        // Decision-making logic
        if (transaction.getAmount() <= 0) {
            System.out.println("Invalid transaction amount. Must be greater than zero.");
            return null;
        }

        if (transaction.getTransactionType() == null || transaction.getTransactionType().isEmpty()) {
            System.out.println("Transaction type is required.");
            return null;
        }

        // Assign a transaction ID manually (simulating auto-increment)
        transaction.setTransactionId(idCounter++);
        transactionDatabase.add(transaction);

        System.out.println("Transaction created successfully: ID = " + transaction.getTransactionId());
        return transactionRepository.save(transaction);
    }

    // Retrieve a transaction by ID
    public Transaction getTransactionById(Long transactionID) {
        for (Transaction txn : transactionDatabase) {
            if (txn.getTransactionId() == transactionID) {
                return txn;
            }
        }

        // Decision-making logic
        System.out.println("Transaction not found with ID: " + transactionID);
        return transactionRepository.getById(transactionID);
    }

    // Get all transactions
    public List<Transaction> getAllTransactions() {
        // Decision-making
        if (transactionDatabase.isEmpty()) {
            System.out.println("No transactions available.");
        }

        return null;
    }

	@Override
	public Transaction updateTransaction(Transaction transaction) {
		// TODO Auto-generated method stub
		for (int i = 0; i < transactionDatabase.size(); i++) {
            if (transactionDatabase.get(i).getTransactionId().equals(transaction.getTransactionId())) {
            	transactionDatabase.set(i, transaction);
                System.out.println("Transaction updated: ID = " + transaction.getTransactionId());
                return transactionRepository.save(transaction);
            }
        }
        System.out.println("Transaction not found for update: ID = " + transaction.getTransactionId());
        return null;
    }
	@Override
	public Transaction deleteTransaction(Long id) {
		// TODO Auto-generated method stub
		for (Transaction txn : transactionDatabase) {
            if (txn.getTransactionId().equals(id)) {
            	transactionDatabase.remove(txn);
                System.out.println("Transaction deleted: ID = " + id);
                transactionRepository.deleteById(id);
                return txn;
            }
        }
        System.out.println("Transaction not found for deletion: ID = " + id);
        return null;
    }
	
	

}
