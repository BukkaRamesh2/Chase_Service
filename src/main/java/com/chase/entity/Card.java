package com.chase.entity;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import com.chase.Test;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name= "cards")
public class Card extends Test {


@Id
@GeneratedValue(strategy =GenerationType.AUTO )
	
	private Long cardId;              
    private String cardType;         
    private Double ROI;              
    private Long customerId;          
    private Integer cardTerm;        
    private LocalDate cardStartDate;  
    private LocalDate cardEndDate;   
    private String status;
    protected String bankname;
    private String email;
    
    
    
   @ElementCollection
   private List<String> phoneNumbers = new ArrayList<>();
   @ElementCollection
   private Map<String,Double> cardInterest = new HashMap<>();
   @ElementCollection
   private Set<String> cardTypes= new HashSet<>();
   
    
    // hello
   public List<String> getPhoneNumbers() {
		return phoneNumbers;
		}
	   public void setPhoneNumbers(List<String> phoneNumbers) {
		this.phoneNumbers = phoneNumbers;
	   }
		public Map<String,Double> getCardInterest() {
			return cardInterest;
		}
		public void setCardInterest(Map<String,Double> cardInterest) {
			this.cardInterest = cardInterest;
		}
		public Set<String> getCardTypes() {
			return cardTypes;
		}
		public void setCardTypes(Set<String> cardTypes) {
			this.cardTypes = cardTypes;
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
	public Double getROI() {
		return ROI;
	}
	public void setROI(Double rOI) {
		ROI = rOI;
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
	/*public void test() {
		System.out.println("Hello in Card class");
	}*/
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCardNumber() {
	    return this.getCardNumber();
	}

	public void test1() {
		// TODO Auto-generated method stub
		
	}
	public void test() {
		// TODO Auto-generated method stub
		
	}
	public int getCvv() {
		// TODO Auto-generated method stub
		return 0;
	}
	

	}
