package com.chase.entity;

import java.util.*;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Branch")
public class Branch {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long branchId;

    private String name;
    private String address;
    private String manager;
    private int code;
    private float timings;
    private String email;
    private String bankName;
    private String branchType;  

    @ElementCollection
    private List<String> servicesOffered = new ArrayList<>();

    @ElementCollection
    private Set<String> employees = new HashSet<>();

    @ElementCollection
    private Map<String, String> contactInfo = new HashMap<>();

    public Branch() {
    }

    public Branch(Long branchId, String name, String address, String manager, int code, float timings) {
        this.branchId = branchId;
        this.name = name;
        this.address = address;
        this.manager = manager;
        this.code = code;
        this.timings = timings;
    }

    // Getters and Setters

    public Long getBranchId() {
        return branchId;
    }

    public void setBranchId(Long branchId) {
        this.branchId = branchId;
    }

    // ✅ Optional overload for String input
    public void setBranchId(String branchIdAsString) {
        this.branchId = Long.parseLong(branchIdAsString);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public float getTimings() {
        return timings;
    }

    public void setTimings(float timings) {
        this.timings = timings;
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

    public String getBranchType() {
        return branchType;
    }

    public void setBranchType(String branchType) {
        this.branchType = branchType;
    }

    public List<String> getServicesOffered() {
        return servicesOffered;
    }

    public void setServicesOffered(List<String> servicesOffered) {
        this.servicesOffered = servicesOffered;
    }

    public Set<String> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<String> employees) {
        this.employees = employees;
    }

    public Map<String, String> getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(Map<String, String> contactInfo) {
        this.contactInfo = contactInfo;
    }
}
