package com.chase.oops;

/*
 * Represents a basic employee with private data fields like name and ID. 
 * Uses getters and setters to access or update this data — demonstrating encapsulation.
 * 
 */

class Employee {
	private String name;
	private int id;

	// Getters and Setters to protect the data (Encapsulation)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void showDetails() {
		System.out.println("Name: " + name + ", ID: " + id);
	}
}
