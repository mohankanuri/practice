package com.riddle;

import java.io.FileNotFoundException;

public class ReadFile {
	public static void main(String[] args) throws FileNotFoundException {
		StringBuffer z = new StringBuffer();
		String str = "rice";
		String str1 = "ice";
		String str2 = "p";
		z.append(str);
		System.out.println("String Buffer Z is appended with 'rice': " + z.toString());
		z.delete(1, 4);
		System.out.println("String Buffer Z after deleting 'ice': " + z.toString());
		z.append(str1);
		System.out.println("String Buffer Z after appending 'ice': " + z.toString());
		z.insert(0, str2);
		System.out.println("String Buffer Z after appending 'p': " + z.toString());
		
	}
}
