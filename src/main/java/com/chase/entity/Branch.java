package com.chase.entity;

public class Branch {
    
  
    public Long branchId;
    public String name;
    public String address;
    public String manager;
    public int code;
    public float timings;

    
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

   
    public Long getBranchId() {
        return branchId;
    }

    public void setBranchId(Long branchId) {
        this.branchId = branchId;
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
}
