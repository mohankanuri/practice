package com.exception;

import java.util.Scanner;

public class ExceptionWithResource {
	public static void main(String[] args){
		int n;
		try(Scanner in =new Scanner(System.in)) {
			System.out.print("Enter n:    ");
			n = in.nextInt();
		}
		    System.out.print("Value of n: " + n);
	}

}
