package com.threads;

public class ThreadUsingJoinAlive {
	
	public static void main(String[] args) throws InterruptedException {
		Thread t1 = new Thread(() -> {
			for (int i = 0; i < 5; i++) {
				System.out.println("Hello");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		Thread t2 = new Thread(() -> {
			for (int i = 0; i < 5; i++) {
				System.out.println("Hi");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}, "Hi Thread");
		t1.start();
		System.out.println(t1.getName());
		t2.start();
		t1.setName("Hello Thread");

		System.out.println(t1.isAlive());

/*		t1.join();
		t2.join();*/

		System.out.println();
		System.out.println(t1.getName());
		System.out.println(t2.getName());

		System.out.println("The final statement");
	}
}
