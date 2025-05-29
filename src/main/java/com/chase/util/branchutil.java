package com.chase.util;


abstract class AbstractBranch {
    public abstract void openBranch();
    public abstract void closeBranch();
}


class BaseBranch extends AbstractBranch {
    private Long branchId;
    private String name;
    private String address;
    private String manager;
    private int code;
    private float timings;

    public BaseBranch(Long branchId, String name, String address, String manager, int code, float timings) {
        this.branchId = branchId;
        this.name = name;
        this.address = address;
        this.manager = manager;
        this.code = code;
        this.timings = timings;
    }

   
    public Long getBranchId() { return branchId; }
    public void setBranchId(Long branchId) { this.branchId = branchId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public String getManager() { return manager; }
    public void setManager(String manager) { this.manager = manager; }

    public int getCode() { return code; }
    public void setCode(int code) { this.code = code; }

    public float getTimings() { return timings; }
    public void setTimings(float timings) { this.timings = timings; }

    
    @Override
    public void openBranch() {
        System.out.println(name + " branch is now OPEN.");
    }

    @Override
    public void closeBranch() {
        System.out.println(name + " branch is now CLOSED.");
    }
}


class CityBranch extends BaseBranch {
    public CityBranch(Long branchId, String name, String address, String manager, int code, float timings) {
        super(branchId, name, address, manager, code, timings);
    }

    @Override
    public void openBranch() {
        System.out.println("City Branch " + getName() + " is open from 9 AM to " + getTimings() + " PM.");
    }
}

class RuralBranch extends BaseBranch {
    public RuralBranch(Long branchId, String name, String address, String manager, int code, float timings) {
        super(branchId, name, address, manager, code, timings);
    }

    @Override
    public void openBranch() {
        System.out.println("Rural Branch " + getName() + " opens at 10 AM and closes at " + getTimings() + " PM.");
    }
}


public class branchutil {
    public static void main(String[] args) {

        
        BaseBranch base = new BaseBranch(1L, "Main Branch", "New York", "Alice", 101, 5.5f);
        base.openBranch();
        base.closeBranch();

       
        BaseBranch city = new CityBranch(2L, "City Hub", "Los Angeles", "Bob", 102, 6.0f);
        BaseBranch rural = new RuralBranch(3L, "Rural Center", "Iowa", "Charlie", 103, 4.0f);

        city.openBranch();  // CityBranch’s override
        rural.openBranch(); // RuralBranch’s override
    }
}