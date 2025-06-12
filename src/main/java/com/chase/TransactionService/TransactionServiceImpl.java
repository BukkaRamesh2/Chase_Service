package com.chase.TransactionService;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chase.TransactionRepository.TransactionRepository;
import com.chase.entity.Transaction;
import com.chase.util.EmailNotificationTask;
import com.chase.util.EmailService;
import com.chase.util.InvalidTransactionException;
import com.chase.util.TransactionEmailComparator;
import com.chase.util.TransactionNotFoundException;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    TransactionRepository transactionRepository;
    
    @Autowired
	EmailService emailService;
    
    
    private static final Logger logger = LoggerFactory.getLogger(TransactionServiceImpl.class);
	private final ExecutorService executorService = Executors.newFixedThreadPool(2);
   
    private List<Transaction> transactionDatabase = new ArrayList<>();
    private static Long idCounter = 1L;
    
  

    public Transaction createTransaction(Transaction transaction) {
    	emailService.sendWelcomeMail(transaction.getName(), transaction.getEmail());
    	
        if (transaction.getAmount() <= 0) {
            throw new InvalidTransactionException("Transaction amount must be greater than zero.");
        }

        if (transaction.getTransactionType() == null || transaction.getTransactionType().isEmpty()) {
            throw new InvalidTransactionException("Transaction type is required.");
        }

        transaction.setTransactionId(idCounter++);
        transactionDatabase.add(transaction);
        
        //if email is null and email does not contain @ invalid format 
        if(transaction.getEmail() == null || !transaction.getEmail().contains("@"))
		{
			System.out.println("Loan having invalid emial format");
			throw new TransactionNotFoundException("Employee having invalid email format ot emial is null");
		}
        
        
        //creating thread for emailNotification  
      //  Runnable emailTask =new EmailNotificationTask(transaction.getEmail(),transaction.getName());
        // new Thread(emailTask).start();
         
         
        
        return transactionRepository.save(transaction);
    }

    public Transaction getTransactionById(Long transactionID) {
        return transactionDatabase.stream()
            .filter(txn -> txn.getTransactionId().equals(transactionID))
            .findFirst()
            .orElseThrow(() -> new TransactionNotFoundException("Transaction not found with ID: " + transactionID));
    }

    public List<Transaction> getAllTransactions() {
    	
    	  List<Transaction> transcation =  transactionRepository.findAll();
    	  
        if (transactionDatabase.isEmpty()) {
            throw new TransactionNotFoundException("No transactions available.");
        }
        
        
      //Collections.sort(transcation);// sort by firstname
       transcation.sort(new TransactionEmailComparator()); //this will sort by email

        return transactionDatabase;
    }

    @Override
    public Transaction updateTransaction(Transaction transaction) {
        for (int i = 0; i < transactionDatabase.size(); i++) {
            if (transactionDatabase.get(i).getTransactionId().equals(transaction.getTransactionId())) {
                transactionDatabase.set(i, transaction);
                return transactionRepository.save(transaction);
            }
        }
        throw new TransactionNotFoundException("Transaction not found for update: ID = " + transaction.getTransactionId());
    }

    @Override
    public Transaction deleteTransaction(Long id) {
        for (Transaction txn : transactionDatabase) {
            if (txn.getTransactionId().equals(id)) {
                transactionDatabase.remove(txn);
                transactionRepository.deleteById(id);
                return txn;
            }
        }
        throw new TransactionNotFoundException("Transaction not found for deletion: ID = " + id);
    }

	
}
