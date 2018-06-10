package studentDataBase;

import java.util.Scanner;

public class Student {
	private String firstName;
	private String lastName;
	private String studentsYear;
	private String studentId;
	private String[] enrollCourses;
	private static int costPerCourse = 600;
	private static int id = 1000;
	private int tuitionFeeBalance;
	private int payment;

	// Constructor
	public Student() {
		Scanner input = new Scanner(System.in);
		// Prompting user to enter first name
		System.out.print("Enter the first name of Student: ");
		this.firstName = input.nextLine();

		// Prompting user to enter last name
		System.out.print("Enter the last name of Student: ");
		this.lastName = input.nextLine();

		// Prompting user to enter the students year
		System.out.print("Enter the student year\n");
		System.out.print("1.Freshmen 2.Somophore 3.Junior 4.Senior\n");
		this.studentsYear = input.nextLine();
		
		//call method to create studentID
		this.studentId = setStudentID();
		
		//call method to enroll in courses;
		this.enrollCourses = setEnrollCourses();
	}

	public String[] setEnrollCourses() {
		String[] enroll= {null};
		String h =null,m =null,e =null,ch =null,co =null;
		System.out.print("Enter the course number you want to enroll");
		Scanner in = new Scanner(System.in);
		while(1!=0) {
			System.out.print("1.History 101 \n2.Mathematics 101 \n3.English 101 \n4.Chemistry 101 "
			                    + "\n5.Computer Science 101 \nAny other number to quit");
			int n = in.nextInt();
			if(n == 1) {h="History 101";}
			else if(n == 2) {m = "Mathematics 101";}
			else if(n == 3) {e = "English 101";}
			else if(n == 4) {ch = "Chemistry 101";}
			else if(n == 5) {co = "Computer Science 101";}
			else if (n !=1||n !=2||n !=3||n !=4||n !=5) {break;}
			}
		in.close();
		for(int i=0;i<5;i++) {
			if(h!=null) {enroll[i] =h;}
			if(m!=null) {enroll[i] = m;}
			if(e!=null) {enroll[i] = e;}
			if(ch!=null) {enroll[i] = ch;}
			if(co!=null) {enroll[i] = co;}
			}
		int leng = enroll.length;
		System.out.println(leng);
		System.out.println("Courses Enrolled are:\n" + enroll);
		return enroll;
	}
	/*
	 call method to calculate the total tution fees;
	 
	 call method to view status for student (balance and payment) - this has
	 to be accessed with student Id and password; 
	 
	 call method to view status of
	 student (view name,id,courses enrolled and balance);
	 
	 */

	
	 private String setStudentID() { 
		 id++;
		 String ID = this.studentsYear+ id;
		 return ID;}
	 

	 
}
