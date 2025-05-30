package com.chase.TransactionService;

import com.chase.entity.Transaction;

import java.util.ArrayList;
import java.util.List;

public class TransactionServiceImpl implements TransactionService {

    private List<Transaction> transactionDatabase = new ArrayList<>();
    private static int idCounter = 1;

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
        return transaction;
    }

    // Retrieve a transaction by ID
    public Transaction getTransactionById(long transactionID) {
        for (Transaction txn : transactionDatabase) {
            if (txn.getTransactionId() == transactionID) {
                return txn;
            }
        }

        // Decision-making logic
        System.out.println("Transaction not found with ID: " + transactionID);
        return null;
    }

    // Get all transactions
    public List<Transaction> getAllTransactions() {
        // Decision-making
        if (transactionDatabase.isEmpty()) {
            System.out.println("No transactions available.");
        }

        return transactionDatabase;
    }

	@Override
	public Transaction updateTransaction(int id, Transaction transaction) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Transaction deleteTransaction(int id) {
		// TODO Auto-generated method stub
		return null;
	}


	
	

}
