package com.chase.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Account")
public class Account {

    public Account() {
    }

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long accountId;
    private Long customerId;
    private String accountType;    
    private Double balance;
    private String routingNumber;
    private boolean isActive;

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

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
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
        this.accountType = "Savings";
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
}
