package com.balaguru;

public class  ThreadsExam {
	/*
	 * @Override public void run() { System.out.println("Hi");
	 * 
	 */
	Runnable obj1 = ()->{System.out.println("Hi");};
	

	public static void main(String[] args) {
		// Thread t1 = new Thread(new ThreadsExam());
		// t1.start();
		//Runnable obj1 = ()->{System.out.println("Hi");};	
		ThreadsExam th = new ThreadsExam();
		Thread t1 = new Thread(th.obj1);
		t1.start();
	}
}
