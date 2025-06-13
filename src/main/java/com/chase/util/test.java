package com.chase.util;

import com.chase.entity.Branch;

public class test {
    public static void main(String[] args) {
        test t1 = new test();
        test t3 = new test();

        t1.tester();
        t1.testinfo();
        t3.tester();


        Branch branch = new Branch();

        
        branch.setBranchId(1234L);

        
        branch.setBranchType("Credit");
        branch.setName("Downtown Branch");
        branch.setAddress("123 Main Street");
        branch.setManager("Alice Smith");
        branch.setCode(101);
        branch.setTimings(9.30f);
        branch.setEmail("branch@example.com");
        branch.setBankName("Chase");

       
        System.out.println("Branch ID: " + branch.getBranchId());
        System.out.println("Branch Type: " + branch.getBranchType());
        System.out.println("Branch Name: " + branch.getName());
        System.out.println("Manager: " + branch.getManager());
        System.out.println("Timings: " + branch.getTimings());
    }

    public void testinfo() {
        System.out.println("Prudhvi");
    }

    public void tester() {
        System.out.println("Hello");
    }
}
