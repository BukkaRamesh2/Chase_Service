package com.chase.oops;

/*
 * Implements the abstract method work() from the Person class. 
 * This shows abstraction in action — the abstract idea of “working” is now implemented specifically.
 * 
 */
class Developer extends Person {
	public void work() {
		System.out.println("Writing code...");
	}
}
