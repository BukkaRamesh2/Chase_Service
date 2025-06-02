package com.chase.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chase.entity.Account;
import com.chase.reposiroty.AccountRepository;

@Service
public class AccountServiceImpl implements AccountService {
	
	@Autowired
	AccountRepository accountRepository;

	@Override
	public Account createAccount(Account account) {
		boolean isValid = true;
		if (account.getCustomerId() == null || account.getCustomerId() <= 0) {
	        System.out.println("Invalid Customer ID.");
	        isValid = false;
	    }

	    if (account.getRoutingNumber() == null || !account.getRoutingNumber().matches("^\\d{9}$")) {
	        System.out.println("Routing number must be a 9-digit number.");
	        isValid = false;
	    }

	    if (account.getBalance() == null || account.getBalance() < 0) {
	        System.out.println("Invalid account balance");
	        isValid = false;
	    }

	    if (account.getAccountType() == null) {
	        System.out.println("Account type cannot be null.");
	        isValid = false;
	    }

	    if (!isValid) {
	        System.out.println("Account creation failed due to invalid input.");
	        return null;
	    }

	    return accountRepository.save(account);
	}

	@Override
	public Account getAccount(Long accountId) {
		if (accountId == null || accountId <= 0) {
	        System.out.println("Invalid account ID provided.");
	        return null;
	    }
		return accountRepository.getById(accountId);
	}

	@Override
	public List<Account> getAllAccounts() {
		 List<Account> accounts = accountRepository.findAll();
		    if (accounts.isEmpty()) {
		        System.out.println("No accounts found in the database.");
		    } else {
		    	accounts.forEach(account -> {
		            if (account.isActive()) {
		                System.out.println("Account ID " + account.getAccountId() + " is active.");
		            }
		        });
		    }
		    return accounts;
	}

	@Override
	public Account updateAccount(Account account) {
		if (account == null || account.getAccountId() == null) {
			System.out.println("Account or Account ID cannot be null.");
	    }

	    if (!accountRepository.existsById(account.getAccountId())) {
	    	System.out.println("Account not found with ID: " + account.getAccountId());
	    }

	    return accountRepository.save(account);
	}

	@Override
	public Account deleteAccount(Long accountId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Account deposit(Long accountId, double amount) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Account withdraw(Long accountId, double amount) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void transfer(Long fromAccountId, Long toAccountId, double amount) {
		// TODO Auto-generated method stub
		
	}
//
//	@Override
//	public List<Account> getAccountsByCustomerId(Long customerId) {
//		// TODO Auto-generated method stub
//		return null;
//	}

    
}
