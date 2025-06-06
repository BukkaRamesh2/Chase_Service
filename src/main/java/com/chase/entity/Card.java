package com.chase.entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Card")
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long cardId;
    private String cardType;
    private String cardNumber;
    private String expiryDate;
    private int cvv;
    private String status;

    private String email;
    protected String bankName;

    @ElementCollection
    private List<String> transactionHistory = new ArrayList<>();

    @ElementCollection
    private Set<String> authorizedMerchants = new HashSet<>();

    @ElementCollection
    private Map<String, Double> cardLimits = new HashMap<>();

    public Card() {
    }

    public Card(Long cardId, String cardType, String cardNumber, String expiryDate, int cvv, String status) {
        this.cardId = cardId;
        this.cardType = cardType;
        this.cardNumber = cardNumber;
        this.expiryDate = expiryDate;
        this.cvv = cvv;
        this.status = status;
    }

    public Long getCardId() {
        return cardId;
    }

    public void setCardId(Long cardId) {
        this.cardId = cardId;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    public int getCvv() {
        return cvv;
    }

    public void setCvv(int cvv) {
        this.cvv = cvv;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public List<String> getTransactionHistory() {
        return transactionHistory;
    }

    public void setTransactionHistory(List<String> transactionHistory) {
        this.transactionHistory = transactionHistory;
    }

    public Set<String> getAuthorizedMerchants() {
        return authorizedMerchants;
    }

    public void setAuthorizedMerchants(Set<String> authorizedMerchants) {
        this.authorizedMerchants = authorizedMerchants;
    }

    public Map<String, Double> getCardLimits() {
        return cardLimits;
    }

    public void setCardLimits(Map<String, Double> cardLimits) {
        this.cardLimits = cardLimits;
    }
}
