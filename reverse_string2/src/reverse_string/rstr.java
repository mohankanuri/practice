package reverse_string;

public class rstr {

	public static void main(String[] args) {
		String city = "DALLAS";
		String crever = "";
		System.out.println("Original string is: " + city);
		int n = city.length();
		for (int i = n - 1; i >= 0; i--) {
			crever = crever + city.charAt(i);
		}
		System.out.println("Reverse string is: " + crever);
	}
}
