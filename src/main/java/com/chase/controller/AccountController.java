package com.chase.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chase.entity.Account;
import com.chase.service.AccountService;

@RestController 
@RequestMapping
public class AccountController {

	public AccountController() {
		// TODO Auto-generated constructor stub
	}
	
	@Autowired
	AccountService accountService;
	
	 @PostMapping
	    public Account createAccount(Account account) {
	        return accountService.createAccount(account);
	    }

	    @GetMapping
	    public Account getAccount(Long accountId) {
	        return accountService.getAccount(accountId);
	    }

	    @GetMapping
	    public List<Account> getAllAccounts() {
	        return accountService.getAllAccounts();
	    }

	    @PutMapping
	    public Account updateAccount(Account account) {
	        return accountService.updateAccount(account);
	    }

	    @DeleteMapping
	    public Account deleteAccount(Long accountId) {
	        return accountService.deleteAccount(accountId);
	    }

	    @PostMapping
	    public Account deposit(Long accountId, double amount) {
	        return accountService.deposit(accountId, amount);
	    }

	    @PostMapping
	    public Account withdraw(Long accountId, double amount) {
	        return accountService.withdraw(accountId, amount);
	    }

	    @PostMapping
	    public void transfer(Long fromAccountId, Long toAccountId, double amount) {
	        accountService.transfer(fromAccountId, toAccountId, amount);
	    }
	    
	    
	    
	    
	    
}
