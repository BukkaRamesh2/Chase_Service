package com.chase.entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.chase.enums.AccountType;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Account")
public class Account implements Comparable<Account> {

    public Account() {
    }

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long accountId;
    private Long customerId;
    
    @Enumerated(EnumType.STRING)
    private AccountType accountType;    
    private Double balance;
    private String routingNumber;
    private boolean isActive;
    
    @ElementCollection
    private List<Long> transactionIds = new ArrayList<>();
    
    @ElementCollection
    private Set<String> authorizedUsers = new HashSet<>();
    
    @ElementCollection
    private Map<String, Double> accountLimits = new HashMap<>();

    public List<Long> getTransactionIds() {
		return transactionIds;
	}

	public void setTransactionIds(List<Long> transactionIds) {
		this.transactionIds = transactionIds;
	}

	public Set<String> getAuthorizedUsers() {
		return authorizedUsers;
	}

	public void setAuthorizedUsers(Set<String> authorizedUsers) {
		this.authorizedUsers = authorizedUsers;
	}

	public Map<String, Double> getAccountLimits() {
		return accountLimits;
	}

	public void setAccountLimits(Map<String, Double> accountLimits) {
		this.accountLimits = accountLimits;
	}

	public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public String getRoutingNumber() {
        return routingNumber;
    }

    public void setRoutingNumber(String routingNumber) {
        this.routingNumber = routingNumber;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
    
    public void addAccount() {

        this.accountId = 1234567890L;
        this.customerId = 1L;
        this.accountType = AccountType.SAVINGS;
        this.balance = 1000.00;
        this.routingNumber = "123456789";
        this.isActive = true;
    }
    
    public void displayAccount() {
        System.out.println("Account ID: " + accountId);
        System.out.println("Customer ID: " + customerId);
        System.out.println("Type: " + accountType);
        System.out.println("Balance: $" + balance);
        System.out.println("Routing Number: " + routingNumber);
        System.out.println("Active: " + isActive);
    }

	@Override
	public int compareTo(Account o) {
		if (this.customerId == null && o.customerId == null) return 0;
		return this.customerId.compareTo(o.getCustomerId());
	}
}
