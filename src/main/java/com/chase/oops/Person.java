package com.chase.oops;

/*
 * An abstract class that only defines a method work() but doesn't implement it. 
 * The idea is that every person must work, but how they work is defined in subclasses like Developer. 
 * This is abstraction — hiding the implementation and showing only essential features.
 */
abstract class Person {
	public abstract void work(); // Only declaration, not implementation
}
