package com.chase.util;

public class TestThread extends Thread {

	    private Thread T;
	    private String threadName;
	   // private Object lock;

	    public TestThread(String name) {
	        this.threadName = name;
	        //this.lock = lock;
	        System.out.println("Thread " + threadName + " State: New");
	    }

	    public void run() {
	    	//synchronized(lock) {
	            // this block is executed by only one thread at a time
	        System.out.println("Thread " + threadName + " State: Running");
	        for (int i = 4; i > 0; i--) {
	            System.out.println("Thread " + threadName + " , " + i);
	           
	        }
	        
	        System.out.println("Thread " + threadName + " State: Dead");


	    }

	    public void start() {
	        System.out.println("Thread " + threadName + " State: Start");
	        if (T == null) {
	            T = new Thread(this, threadName);
	            T.start();
	        }
	    }

	    public static void main(String[] args) {
	    	//Object lock = new Object();
	        TestThread t1 = new TestThread("Thread-1");
	        TestThread t2 = new TestThread("Thread-2");
	        t1.start();
	        t2.start();
	    }
	}