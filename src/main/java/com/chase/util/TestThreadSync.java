package com.chase.util;

public class TestThreadSync extends Thread {

    private Thread T; 
    private String threadName;

    public TestThreadSync(String name) {
        this.threadName = name;
        System.out.println("Thread " + threadName + " State: New");
    }

    public void run() {
        System.out.println("Thread " + threadName + " State: Running");
        for (int i = 4; i > 0; i--) {
            System.out.println("Thread " + threadName + ", " + i);
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

    public void joinThread() {
        try {
            if (T != null) {
                T.join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        TestThreadSync t1 = new TestThreadSync("Thread-1");
        TestThreadSync t2 = new TestThreadSync("Thread-2");

        t1.start();
        t1.joinThread();

        t2.start();
        t2.joinThread();
    }
}
