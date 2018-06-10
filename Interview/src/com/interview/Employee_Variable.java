//This program is used to demonstrate local, instance and class variables 
package com.interview;

import java.util.Scanner;

public class Employee_Variable {
	
	// this instance variable is visible for any child class.
	public String name;
	
	// Instance variable - salary is visible in Employee class only.
	private double salary;
	
	//Class variable - DateOfBirth is defined inside class, but not defined in any method
	//And Access modifier used is static
	private static String DateOfBirth;
	
	// The nm variable is defined in the constructor, hence nm is a local variable.
	public Employee_Variable(String empName) {String nm = empName; name = nm;}

	// The salary variable is assigned a value.
	public void setSalary(double empSal) {salary = empSal;}

	// This method prints the employee details.
	public void printEmp() {System.out.println("name  : " + name);System.out.println("salary :" + salary);}

	public static void main(String args[]) {
		Employee_Variable empOne = new Employee_Variable("Ransika");
		empOne.setSalary(1000);
		empOne.printEmp();
		empOne.getDateOfBirth();
		}

	public static String getDateOfBirth() {
		System.out.println("Enter Date of birth of employee:");
		Scanner in = new Scanner(System.in);
		String str = in.nextLine();
		in.close();
		return DateOfBirth = str;
		
	}

	public static void setDateOfBirth(String dateOfBirth) {
		DateOfBirth = dateOfBirth;
	}
}

