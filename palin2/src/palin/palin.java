package palin;
import java.util.Scanner;
public class palin {
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Enter number to check palindrome: ");
		int n = keyboard.nextInt();
		int N=n;
		int m;
		m = n%10;
		for(;n>1;)
		{
			n=n/10;
			m=(m*10)+(n%10);
		}
		//m=m/10;
		if(m==N)
			System.out.println("Entered number is Palindrome");
		else
			System.out.println("Entered number is not Palindrome");
	}
}
