package com.riddle;

import java.util.Scanner;

public class ChangeCalculator {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("Enter the total check value in pennies: ");
		int checkValue = in.nextInt();
		System.out.print("Enter bill value (1 = $1 bill, 5 = $5 bill, 20 = $20 bill, 50 =$50 bill, 100 = $100 bill): ");
		int billValue = in.nextInt()*100;
		
		int dollars = (billValue -checkValue)/100;
		int quarters = (billValue - checkValue - (dollars*100))/25;
		int dimes = (billValue - checkValue - (dollars*100)- (quarters*25))/10;
		int nickels = (billValue - checkValue - (dollars*100)- (quarters*25) - (dimes*10))/5;
		int pennies = (billValue - checkValue - (dollars*100)- (quarters*25) - (dimes*10) - (nickels*5));
		System.out.println("The change is:");
		System.out.println("Dollars  \t"+ dollars);
		System.out.println("Quarters  \t"+ quarters);
		System.out.println("Dimes      \t"+ dimes);
		System.out.println("Nickels     \t"+ nickels);
		System.out.println("Pennies      \t"+ pennies);
		in.close();
	}

}
