package com.chase.oops;
/*
 * Inherits from the Employee class and adds extra behavior (manageTeam() method). 
 * This shows inheritance, where a child class gets the properties and methods of a parent class.
 * 
 */
class Manager extends Employee {
    public void manageTeam() {
        System.out.println("Managing team...");
    }
}
