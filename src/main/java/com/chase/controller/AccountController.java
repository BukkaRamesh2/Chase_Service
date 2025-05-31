package com.chase.controller;

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
	
	 @PostMapping("/createAccount")
	    public Account createAccount(@RequestBody Account account) {
	        return accountService.createAccount(account);
	    }

	    @GetMapping("getAccount/{accountId}")
	    public Account getAccount(@PathVariable Long accountId) {
	        return accountService.getAccount(accountId);
	    }

	    @GetMapping("getAllAccounts")
	    public List<Account> getAllAccounts() {
	        return accountService.getAllAccounts();
	    }

	    @PutMapping("/updateAccount")
	    public Account updateAccount(@RequestBody Account account) {
	        return accountService.updateAccount(account);
	    }

	    @DeleteMapping("/deleteAccount/{accountId}")
	    public Account deleteAccount(@PathVariable Long accountId) {
	        return accountService.deleteAccount(accountId);
	    }

	    @PostMapping("/deposit")
	    public Account deposit(@PathVariable Long accountId, @PathVariable double amount) {
	        return accountService.deposit(accountId, amount);
	    }

	    @PostMapping("/withdraw")
	    public Account withdraw(@PathVariable Long accountId, @PathVariable double amount) {
	        return accountService.withdraw(accountId, amount);
	    }

	    @PostMapping("/transfer")
	    public void transfer(@PathVariable Long fromAccountId, @PathVariable Long toAccountId, @PathVariable double amount) {
	        accountService.transfer(fromAccountId, toAccountId, amount);
	    }
	    
	    
	    
	    
	    
}
