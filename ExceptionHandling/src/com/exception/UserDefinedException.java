package com.exception;

import java.util.Scanner;

class MyException extends Exception {
	public MyException() {
		System.out.println("The array size cannot be more than 5");
	}
}

public class UserDefinedException {
	public static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {
		boolean choice = true;

		do {
			try {
				System.out.println("Enter the size of array: ");
				int s = in.nextInt();
				int[] n = new int[s];
				for (int i = 0; i < n.length; i++) {
					if (n.length > 5) {
						throw new MyException();
					}
					n[i] = i;
				}
				for (int i = 0; i < n.length; i++) {
					System.out.print(n[i] + "\t");
				}
				choice = false;
			} catch (Exception MyException) {
				choice = true;
			}
		} while (choice);
		System.out.println("rest of the code...");
		in.close();
	}
}