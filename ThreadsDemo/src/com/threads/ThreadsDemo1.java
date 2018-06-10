package com.threads;

class trd extends Thread {
	@Override
	public void run() {
		System.out.println("Thread is running from thread class");
	}
}

class trdd implements Runnable {
	@Override
	public void run() {
		System.out.println("Thread is running from Runnable interface");

	}
}

public class ThreadsDemo1 {

	public static void main(String[] args) throws InterruptedException{

		trd trd1 = new trd();
		Thread trd2 = new Thread(new trdd());
		
		trd1.start();
		trd2.start();
		
		for(int i=0;i<5;i++) {trd1.run();
		Thread.sleep(1000);
		trd2.run();}
		
		System.out.println();
		
		
		System.out.println(trd2.getName());
		

		System.out.println(trd1.getName());
	}
}
