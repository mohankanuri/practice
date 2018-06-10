package com.threads;

public class ThreadUsingLambda {

	public static void main(String[] args) throws InterruptedException {
		Thread t1 = new Thread(() -> {System.out.println("Hi");});
		Runnable t2 = ()->{System.out.println("Hello");};
		Thread t3 = new Thread(t2);
		
		for(int i=0;i<5;i++) {
		t1.run();
		Thread.sleep(1000);
		t3.run();}
		
	}
}
