package com.chase.oops;

/*
 * Runs the entire program. 
 * It creates objects for each class 
 * and demonstrates Encapsulation, Inheritance, Abstraction, and Polymorphism in action.
 * 
 */
public class Main {
	public static void main(String[] args) {
		// Encapsulation
		Employee emp = new Employee();
		emp.setName("Pavan");
		emp.setId(101);
		emp.showDetails();

		// Inheritance
		Manager mgr = new Manager();
		mgr.setName("Klassen");
		mgr.setId(102);
		mgr.showDetails();
		mgr.manageTeam();

		// Abstraction
		Person dev = new Developer();
		dev.work();

		// Polymorphism
		Employee tester = new Tester();
		tester.setName("Cumins");
		tester.setId(103);
		tester.showDetails(); // Calls overridden method
	}
}
