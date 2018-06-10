package com.threads;

public class ThreadPriority {
public static void main(String[] args) throws InterruptedException {
	Thread t1 = new Thread(()->{System.out.println("Hi Thread");});
	Thread t2 = new Thread(()->{System.out.println("Hello Thread");});
	
	t1.start();
	t1.join();
	t2.start();
	
	t1.setPriority(Thread.MAX_PRIORITY);
	t2.setPriority(Thread.MIN_PRIORITY);
	
	
	
	System.out.println(t1.getPriority());
	System.out.println(t2.getPriority());
}
}
