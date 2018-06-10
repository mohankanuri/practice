package com.threads;

class A extends Thread{
	@Override
	public void run() {
	for(int i=1;i<=5;i++) {
		System.out.println("\tFrom thread A.i =  "+i);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	}
}
class ThreadClass {
	public static void main(String[] args) {
		A a = new A();
		a.start();

	}
}
