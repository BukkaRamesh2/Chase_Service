package com.chase.entity;
import java.time.LocalDate;


public class Insurance {
	
	
	private String customername;
	private Long customerId;
	private Long insuranceId;
	private String insuranceType;
	private Integer insuranceTerm;
	private LocalDate insuranceStartDate;
	private LocalDate insuranceEndDate;
	private Boolean status;
	//hello add
	
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
	
	
}
