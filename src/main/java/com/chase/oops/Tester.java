package com.chase.oops;

/*
 * Inherits from Employee but overrides the showDetails() method to provide a custom version. 
 * This is runtime polymorphism — the method that gets called depends on the object type at runtime.
 * 
 * 
 */
class Tester extends Employee {
	@Override
	public void showDetails() {
		System.out.println("Tester Details: " + getName() + ", ID: " + getId());
	}
}
