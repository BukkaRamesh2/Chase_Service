package com.chase.entity;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.chase.Test;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "insurances")
public class Insurance{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	
	private Long insuranceId;
	private String customername;
	private Long customerId;
	private String insuranceType;
	private Integer insuranceTerm;
	private LocalDate insuranceStartDate;
	private LocalDate insuranceEndDate;
	private Boolean status;
	protected String bankname;
	private String email;
	
	
	
	@ElementCollection
	private List<String> phoneNumbers = new ArrayList();
	@ElementCollection
	private Map<String,Double> insuranceInterest = new HashMap<>();
	@ElementCollection
	private Set<String> insuranceTypes = new HashSet<>();
	
	  // hello
	   public List<String> getPhoneNumbers() {
			return phoneNumbers;
			}
		   public void setPhoneNumbers(List<String> phoneNumbers) {
			this.phoneNumbers = phoneNumbers;
		   }
			public Map<String,Double> getInsuranceInterest() {
				return insuranceInterest;
			}
			public void setInsuranceInterest(Map<String,Double> insuranceInterest) {
				this.insuranceInterest = insuranceInterest;
			}
			public Set<String> getInsuranceTypes() {
				return insuranceTypes;
			}
			public void setInsuranceTypes(Set<String> insuranceTypes) {
				this.insuranceTypes = insuranceTypes;
			}
	
	
	public String getCustomername() {
		return customername;
	}
	public void setCustomername(String customername) {
		this.customername = customername;
	}
	
	public Long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
	public Long getInsuranceId() {
		return insuranceId;
	}
	public void setInsuranceId(Long insuranceId) {
		this.insuranceId = insuranceId;
	}
	public String getInsuranceType() {
		return insuranceType;
	}
	public void setInsuranceType(String insuranceType) {
		this.insuranceType = insuranceType;
	}
	public Integer getInsuranceTerm() {
		return insuranceTerm;
	}
	public void setInsuranceTerm(Integer insuranceTerm) {
		this.insuranceTerm = insuranceTerm;
	}
	public LocalDate getInsuranceStartDate() {
		return insuranceStartDate;
	}
	public void setInsuranceStartDate(LocalDate insuranceStartDate) {
		this.insuranceStartDate = insuranceStartDate;
	}
	public LocalDate getInsuranceEndDate() {
		return insuranceEndDate;
	}
	public void setInsuranceEndDate(LocalDate insuranceEndDate) {
		this.insuranceEndDate = insuranceEndDate;
	}
	public Boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	
	//public void displayuser() {
		//System.out.println("This is message from Insurance class");
	//}
}
