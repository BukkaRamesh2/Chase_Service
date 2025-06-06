package com.chase.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chase.entity.Account;
import com.chase.reposiroty.AccountRepository;
import com.chase.util.AccountNotFoundException;

@Service
public class AccountServiceImpl implements AccountService {
	
	@Autowired
	AccountRepository accountRepository;

	@Override
	public Account createAccount(Account account){
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
	    if (account.getTransactionIds() == null) {
	        account.setTransactionIds(new ArrayList<>());
	    }
	    if (account.getAuthorizedUsers() == null) {
	        account.setAuthorizedUsers(new HashSet<>());
	    }
	    if (account.getAccountLimits() == null) {
	        account.setAccountLimits(new HashMap<>());
	    }

	    if (!isValid) {
	        System.out.println("Account creation failed due to invalid input.");
	        throw new IllegalArgumentException("Something in Account details is null");
	    }
	    
	    try {
	    
		    List<String> originalList = new ArrayList<>(account.getAuthorizedUsers());
	
		    List<String> arrayList = new ArrayList<>(originalList);
		    List<String> linkedList = new LinkedList<>(originalList);
	
		    long startArray = System.nanoTime();
		    arrayList.add("User1");
		    arrayList.add("User2");
		    arrayList.add("User3");
		    long endArray = System.nanoTime();
	
		    long startLinked = System.nanoTime();
		    linkedList.add("LinkedUser1");
		    linkedList.add("LinkedUser2");
		    linkedList.add("LinkedUser3");
		    long endLinked = System.nanoTime();
	
		    System.out.println("ArrayList add operation time: " + (endArray - startArray) + " ns");
		    System.out.println("LinkedList add operation time: " + (endLinked - startLinked) + " ns");
		    
	    }catch(Exception e){
	    	e.printStackTrace();
	    }
	    

	    return accountRepository.save(account);
	}

	@Override
	public Account getAccount(Long accountId) {
		if (accountId == null || accountId <= 0) {
	        System.out.println("Invalid account ID provided.");
	        throw new AccountNotFoundException();
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
		    	
		    	Map<String, List<Account>> hashMap = new HashMap<>();
		        Map<String, List<Account>> linkedHashMap = new LinkedHashMap<>();
		        Map<String, List<Account>> treeMap = new TreeMap<>();
		        
		        for (Account account : accounts) {
		            String routingNum = account.getRoutingNumber();
		            if (routingNum == null) {
		                routingNum = "UNKNOWN";
		            }
		            hashMap.computeIfAbsent(routingNum, k -> new ArrayList<>()).add(account);
		            linkedHashMap.computeIfAbsent(routingNum, k -> new ArrayList<>()).add(account);
		            treeMap.computeIfAbsent(routingNum, k -> new ArrayList<>()).add(account);
		        }

		        System.out.println("HashMap keys (routing numbers): " + hashMap.keySet());
		        System.out.println("LinkedHashMap keys (routing numbers): " + linkedHashMap.keySet());
		        System.out.println("TreeMap keys (routing numbers): " + treeMap.keySet());
		        
		    }
		    return accounts;
	}

	@Override
	public Account updateAccount(Account account) {
		if (account == null || account.getAccountId() == null) {
			System.out.println("Account or Account ID cannot be null.");
			throw new AccountNotFoundException("Account not found");
	    }

	    if (!accountRepository.existsById(account.getAccountId())) {
	    	System.out.println("Account not found with ID: " + account.getAccountId());
	    	return null;
	    }

	    if (account.getTransactionIds() == null) {
	        account.setTransactionIds(new ArrayList<>());
	    }
	    if (account.getAuthorizedUsers() == null) {
	        account.setAuthorizedUsers(new HashSet<>());
	    }
	    if (account.getAccountLimits() == null) {
	        account.setAccountLimits(new HashMap<>());
	    }

	    Set<String> rawSet = account.getAuthorizedUsers();
	    rawSet.removeIf(user -> user == null || user.trim().isEmpty());
	    
	    Set<String> hashSet = new HashSet<>(rawSet);
	    Set<String> linkedHashSet = new LinkedHashSet<>(rawSet);
	    Set<String> treeSet = new TreeSet<>(rawSet);
	    
	    System.out.println("HashSet (unordered): " + hashSet);
	    System.out.println("LinkedHashSet (insertion order): " + linkedHashSet);
	    System.out.println("TreeSet (sorted order): " + treeSet);
	    
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
	
	public Account addTransactionId(Long accountId, Long transactionId) {
	    Account account = accountRepository.findById(accountId).orElse(null);
	    if (account == null) {
	        System.out.println("Account not found.");
	        return null;
	    }
	    account.getTransactionIds().add(transactionId);
	    return accountRepository.save(account);
	}
	public Account addAuthorizedUser(Long accountId, String userEmail) {
	    Account account = accountRepository.findById(accountId).orElse(null);
	    if (account == null) {
	        System.out.println("Account not found.");
	        return null;
	    }
	    account.getAuthorizedUsers().add(userEmail);
	    return accountRepository.save(account);
	}

	public Account updateAccountLimit(Long accountId, String limitType, Double limitValue) {
	    Account account = accountRepository.findById(accountId).orElse(null);
	    if (account == null) {
	        System.out.println("Account not found.");
	        return null;
	    }
	    account.getAccountLimits().put(limitType, limitValue);
	    return accountRepository.save(account);
	}

    
}
