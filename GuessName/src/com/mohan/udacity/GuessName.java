package com.mohan.udacity;
import java.util.*;
public class GuessName {

	public static void main(String[] args) {
		int numberPicked = (int) (Math.random()*100)+1;
		System.out.println("Guess the random number picked from 1 to 100 ");
		Scanner input = new Scanner(System.in);
		for(int i=10;i>0;i--)
		{
			int numberGuessed = input.nextInt();
			if(numberGuessed == numberPicked){System.out.println("You guessed the right number, Number picked is: " + numberPicked);break;}
			else if(numberGuessed > numberPicked) {System.out.println("Your guessed number is bigger than the picked number");}
			else if(numberGuessed < numberPicked) {System.out.println("Your guessed number is smaller than the picked number");}
			if(i>0) {System.out.println("You have: " + (i-1) + " chances");}
			else if(i==0) {System.out.println("Better luck next time"); System.out.println("The number was: " + numberPicked);}
		}

	input.close();
	}
}
