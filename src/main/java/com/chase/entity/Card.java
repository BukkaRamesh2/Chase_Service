package com.chase.entity;

import java.time.LocalDate;
import java.util.*;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "cards")
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long cardId;

    private String cardNumber;
    private String cardType;
    private Double ROI;
    private Long customerId;
    private Integer cardTerm;
    private LocalDate cardStartDate;
    private LocalDate cardEndDate;
    private String status;
    private String bankname;
    private String email;
    private int cvv;

    @ElementCollection
    private List<String> phoneNumbers = new ArrayList<>();

    @ElementCollection
    private Map<String, Double> cardInterest = new HashMap<>();

    @ElementCollection
    private Set<String> cardTypes = new HashSet<>();

    // Getters and Setters
    public Long getCardId() {
        return cardId;
    }

    public void setCardId(Long cardId) {
        this.cardId = cardId;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public Double getROI() {
        return ROI;
    }

    public void setROI(Double ROI) {
        this.ROI = ROI;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Integer getCardTerm() {
        return cardTerm;
    }

    public void setCardTerm(Integer cardTerm) {
        this.cardTerm = cardTerm;
    }

    public LocalDate getCardStartDate() {
        return cardStartDate;
    }

    public void setCardStartDate(LocalDate cardStartDate) {
        this.cardStartDate = cardStartDate;
    }

    public LocalDate getCardEndDate() {
        return cardEndDate;
    }

    public void setCardEndDate(LocalDate cardEndDate) {
        this.cardEndDate = cardEndDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getBankname() {
        return bankname;
    }

    public void setBankname(String bankname) {
        this.bankname = bankname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getCvv() {
        return cvv;
    }

    public void setCvv(int cvv) {
        this.cvv = cvv;
    }

    public List<String> getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(List<String> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    public Map<String, Double> getCardInterest() {
        return cardInterest;
    }

    public void setCardInterest(Map<String, Double> cardInterest) {
        this.cardInterest = cardInterest;
    }

    public Set<String> getCardTypes() {
        return cardTypes;
    }

    public void setCardTypes(Set<String> cardTypes) {
        this.cardTypes = cardTypes;
    }
}
