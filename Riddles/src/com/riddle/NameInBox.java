package com.riddle;

import java.util.Scanner;

public class NameInBox {
public static void main(String[] args) {
	Scanner input = new Scanner(System.in);
	System.out.println("Enter your name");
	String name = input.nextLine();
	System.out.print("+");
	for(int i=0;i<(name.length()+4);i++) {
		System.out.print("-");
	}
	System.out.println("+");
	System.out.print("|");
	System.out.print("  ");
	System.out.print(name);
	System.out.print("  ");
	System.out.println("|");
	System.out.print("+");
	for(int i=0;i<(name.length()+4);i++) {
		System.out.print("-");
	}
	System.out.print("+");
	input.close();
}
}
