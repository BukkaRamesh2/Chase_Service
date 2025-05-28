package com.chase.TransactionService;

import java.util.List;

import com.chase.entity.Transaction;

public interface TransactionService {
	Transaction createTransaction(Transaction transaction);
    Transaction getTransactionById(long transactionID);
    List<Transaction> getAllTransactions();
    Transaction updateTransaction(int id, Transaction transaction);
    Transaction deleteTransaction(int id);
}
