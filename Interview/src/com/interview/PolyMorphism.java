package com.interview;

public class PolyMorphism {
	int calc(int var1, int var2, int choice) {
		int add = var1 + var2;
		int sub = var1 - var2;
		int mul = var1 * var2;
		int div = var1 / var2;
		int calc = 0;
		if (choice == 1) calc = add;
		else if (choice == 2) calc = sub;
		else if (choice == 3) calc = mul;
		else if (choice == 4) calc = div;
		return calc;
	}

	double calc(int var1, int var2, int var3, int choice) {
		double add = ((double) var1) + var2 + var3;
		double sub = ((double) var1) - var2 - var3;
		double mul = ((double) var1) * var2 * var3;
		double div = ((double) var1) / (var2 * var3);
		double calc = 0;
		if (choice == 1)
			calc = add;
		else if (choice == 2)
			calc = sub;
		else if (choice == 3)
			calc = mul;
		else if (choice == 4)
			calc = div;
		return calc;
	}

	public static void main(String[] args) {
		int a = 2, b = 6, c = 5;
		PolyMorphism cls = new PolyMorphism();
		int ad = cls.calc(a, b, 1);
		int sb = cls.calc(a, b, 2);
		int ml = cls.calc(a, b, 3);
		double dv = cls.calc(a, b, 4);
		System.out.println("Add: " + ad + " Sub: " + sb + " Mul: " + ml + " Div: " + dv);

		double adThree = cls.calc(a, b, c, 1);
		System.out.println("Addition using poly: " + adThree);
		double sbThree = cls.calc(a, b, c, 2);
		System.out.println("Subtraction using poly: " + sbThree);
		double mlThree = cls.calc(a, b, c, 3);
		System.out.println("Multiplication using poly: " + mlThree);
		double dvThree = cls.calc(a, b, c, 4);
		System.out.println("Division using poly: " + dvThree);

	}
}