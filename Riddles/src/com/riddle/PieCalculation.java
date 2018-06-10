package com.riddle;

import java.util.Scanner;

public class PieCalculation {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter value of n");
		int n = input.nextInt();
		float[] pieArray = new float[n];
		float pieValue = 0;
		float a = 0;
		for (int i = 0; i < n; i++) {
			pieArray[i] = 1 / (2 * a + 1);
			a++;
		}
		for (int i = 0; i < n; i++) {
			if (i % 2 == 1) {
				pieArray[i] = -pieArray[i];
			}
			if (i % 2 == 0) {
				pieArray[i] = pieArray[i];
			}
		}
		for (int i = 0; i < n; i++) {
			pieValue = pieValue + pieArray[i];
		}
		System.out.println("The value of pie to n digits is: " + (pieValue * 4));
		input.close();
	}

}
