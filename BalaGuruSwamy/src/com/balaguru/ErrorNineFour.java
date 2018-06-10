package com.balaguru;

public class ErrorNineFour {
	public static void main(String[] args) {
		Thread t = new Thread(() -> {
			for (int i = 0; i < 100; i++) {
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("From thread t " + i);
			}
		});
		t.start();
		System.out.println("In main thread");

	}
}