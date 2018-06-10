package com.exception;

import java.util.Scanner;

public class ArrayExcep {
	public static void siz(int[] arr) {
		int s = arr.length;
		if (s > 5)
			throw new RuntimeExcep();
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		boolean ch = true;
		do {
			try {
				System.out.println("Enter array size");
				int s = in.nextInt();
				int[] n = new int[s];
				siz(n);
				for (int i = 0; i < n.length; i++) {
					System.out.println("Enter the " + (i + 1) + " element of Array: ");
					n[i] = in.nextInt();
				}
				System.out.println("The array n is as follows: ");
				for (int i = 0; i < n.length; i++) {
					System.out.print(n[i] + "\t");
				}
				ch = false;
			} catch (RuntimeExcep e) {
				System.out.println(e.getMessage());
				ch = true;
			}
		} while (ch);

		in.close();
	}

}
