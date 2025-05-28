package com.chase.service;

import java.util.List;

import com.chase.entity.Account;

public interface AccountService {
    public Account createAccount(Account account);
    public Account getAccount(Long accountId);
    public List<Account> getAllAccounts();
    public Account updateAccount(Account account);
    public Account deleteAccount(Long accountId);

    public Account deposit(Long accountId, double amount);
    public Account withdraw(Long accountId, double amount);
    public void transfer(Long fromAccountId, Long toAccountId, double amount);

    //public List<Account> getAccountsByCustomerId(Long customerId);
}
