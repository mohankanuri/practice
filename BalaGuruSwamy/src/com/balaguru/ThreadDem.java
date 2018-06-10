package com.balaguru;

public class ThreadDem {
	public static void main(String[] args) throws DividebyTwoException {
		int div =2;
		int a=20;
		if(div == 2)
		{
			throw new DividebyTwoException();
		}
		else
		{
			int c=a/div;
		}
	}
}

class DividebyTwoException extends Exception {
	
	public DividebyTwoException()
	{
		System.out.print("Divide by 2 Excepition");
	}
}