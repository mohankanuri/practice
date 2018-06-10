package com.riddle;

import java.util.Scanner;

public class EasterSundayCalculator {
	public static void main(String[] args) {
		System.out.print("Enter the year you want to calculate Easter day of: ");
		Scanner in = new Scanner(System.in);
		int year = in.nextInt();
		int a = year%19, b = year/100, c = year%100;
		int d = b/4, e =b%4, g = (8*b+13)/25;
		int h = (19*a+b-d-g+15)%30;
		int j = c/4, k =c%4, m = (a+11*h)/319, r = (2*e+2*j-k-h+m+32)%7;
		int n = (h-m+r+90)/25, p = (h-m+r+n+19)%32;
		String monthString;
		   switch (n) {
		   			case 1:  monthString = "January";break;
		   			case 2:  monthString = "February";break;
		   			case 3:  monthString = "March";break;
		   			case 4:  monthString = "April";break;
		   			case 5:  monthString = "May";break;
		   			case 6:  monthString = "June";break;
		   			case 7:  monthString = "July";break;
		   			case 8:  monthString = "August";break;
		   			case 9:  monthString = "September";break;
		   			case 10: monthString = "October";break;
		   			case 11: monthString = "November";break;
		   			case 12: monthString = "December";break;
		   			default: monthString = "Invalid month";break;
		   			}
		   System.out.println("The Easter for " + year + " year falls on " + monthString + " " + p);

		in.close();
	}

}
