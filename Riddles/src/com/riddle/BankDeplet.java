package com.riddle;

import java.util.Scanner;

public class BankDeplet {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the principle amount");
		double principle = input.nextDouble();
		System.out.println("Enter the rate of interest per month that will be compounded");
		double rateOfInterest = (input.nextDouble()/100);
		System.out.println("Enter the amount withdrawn every month");
		double withDraw = input.nextDouble();
		int months = 0;
		for (int n = 1; (principle >= 0); n++) {
			principle = principle + (principle * rateOfInterest);
			principle = principle - withDraw;
			if (principle < 0) {
				months = n + 1;
				principle = principle + withDraw;
				principle = principle - (principle * rateOfInterest);
				break;
			}
		}
		System.out.println("The amount will be depriciated to " + principle + " in " + months + " months");
		input.close();
	}
}
