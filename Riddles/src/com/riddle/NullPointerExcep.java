package com.riddle;

import java.util.ArrayList;

public class NullPointerExcep {
	public static void main(String[] args) {
		ArrayList<String> str = new ArrayList<>(5);
		str.add(0, "e");
		str.add(1, "r");
		str.add(2, "r");
		str.add(3, "o");
		str.add(4, "r");
		
		System.out.println(str.toString());
		
		System.out.println("");
		
		for (int i = 0; i < str.size(); i++) {
			System.out.print(str.get(i)+"\t");
		}
		
	}

}
