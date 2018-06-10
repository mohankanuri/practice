package com.mohan.email;

import java.util.ArrayList;
import java.util.Scanner;

public class EmailApp{

	public static void main(String[] args) {
		System.out.println("Enter number of new email Id's you want to create");
		Scanner numberOfEmployee = new Scanner(System.in);
		int EmployeeNumber = numberOfEmployee.nextInt();
		ArrayList<Email> employeeList = new ArrayList<Email>();
		for (int i = 0; i < EmployeeNumber; i++) {
			Scanner FN = new Scanner(System.in);
			Scanner LN = new Scanner(System.in);
			System.out.println("Enter first name of " + (i+1) + " employee");
			String firstName = FN.nextLine();
			System.out.println("Enter last name of " + (i+1) + " employee");
			String lastName = LN.nextLine();
			Email employee = new Email(firstName, lastName);
			employeeList.add(employee);}

		System.out.println();		
		for(int i=0;i<employeeList.size();i++) {
			System.out.println((i+1) + " employee");
			employeeList.get(i).Info();
			System.out.println();}
		}
	}