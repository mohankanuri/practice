package com.mohan.email;

import java.util.Scanner;

public class Email {
	private String firstName;
	private String lastName;
	private String department;
	private String email;
	private String password;
	private String alternateEmail;
	private int mailboxCapacity;
	private String company = "rstechnologies.com";
	
	// Constructor to get first and last name
	public Email(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
		// Call method to ask for department
		this.department = getDepartment();
		// Call method to create email id
		this.email = getEmail();
		// Call method to create password
		this.password = getPassword();
		// Call method to create alternate email
		this.alternateEmail = getAlternateEmail();
		// Call method to set mailbox capacity
		this.mailboxCapacity = setMailboxCapacity();}

	// Method for asking department
	public String getDepartment() {
		System.out.println("Enter the department code 1.For 'Sales' 2.For 'Development' 3.For Accounting 0.For none");
		Scanner inputDep = new Scanner(System.in);
		int choiceDep = inputDep.nextInt();
		if (choiceDep == 1) {
			return "Sales";
		} else if (choiceDep == 2) {
			return "Development";
		} else if (choiceDep == 3) {
			return "Accounting";
		} else
			return "";
	}

	// Method to create email Id
	public String getEmail() {
		String eml = this.firstName.toLowerCase() + "." + this.lastName.toLowerCase() + "@" + this.department.toLowerCase() + this.company.toLowerCase();
		return eml;
	}

	// Method for Random generated password
	public String passwordRandom() {
		char[] in = { 'A', 'a', 'B', 'b', 'C', 'c', 'D', 'd', 'E', 'e', 'F', 'f', 'G', 'g', 'H', 'h', 'I', 'i', 'J',
				'j', 'K', 'k', 'L', 'l', 'M', 'm', 'O', 'o', 'P', 'p', 'Q', 'q', 'R', 'r', 'S', 's', 'T', 't', 'U', 'u',
				'V', 'v', 'W', 'w', 'X', 'x', 'Y', 'y', 'Z', 'z', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '~',
				'!', '@', '#', '$', '%', '&' };
		char[] se = { 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a' };
		String passwordR;
		int[] gnt = new int[10];
		for (int i = 0; i < 10; i++) {
			gnt[i] = (int) (Math.random() * (in.length - 1));
		}
		for (int i = 0; i < 10; i++) {
			se[i] = in[gnt[i]];
		}
		passwordR = String.valueOf(se);
		return passwordR;
	}

	// Method to create password
	public String getPassword() {
		System.out.println("Your random generated password is: " + this.passwordRandom());
		System.out.println("Do you want to change it (1.Yes 2.No)");
		Scanner inputPass = new Scanner(System.in);
		int choice = inputPass.nextInt();
		if (choice == 1) {
			System.out.println("Enter your new password");
			Scanner pwd = new Scanner(System.in);
			return pwd.nextLine();
		} else {
			return this.passwordRandom();
		}
	}

	// Method to create alternate email id
	public String getAlternateEmail() {
		System.out.println("Do you want to have an alternate email? 1.Yes 2.No");
		Scanner choice = new Scanner(System.in);
		int n = choice.nextInt();
		if (n == 1) {
			System.out.println("Enter alternate email");
			Scanner eml = new Scanner(System.in);
			return eml.nextLine();
		} else {
			return "null";
		}
	}

	// Method to set mailbox capacity
	public int setMailboxCapacity() {
		if (this.department == "Sales") {
			return 200;
		} else if (this.department == "Development") {
			return 20;
		} else if (this.department == "Accounting") {
			return 50;
		} else if (this.department == "") {
			return 10;
		}
		return 0;
	}

	// Method to print basic info of employee
	public void Info() {
		System.out.println("\tFirst name:" + this.firstName);
		System.out.println("\tLast name:" + this.lastName);
		System.out.println("\tDepartment: " + this.department);
		System.out.println("\tCompany Email: " + this.email);
		System.out.println("\tMailbox capacity(daiy): " + this.mailboxCapacity);
		System.out.println("\tAlternate Email: " + this.alternateEmail);}

}