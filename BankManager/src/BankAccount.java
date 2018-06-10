
public class BankAccount {
	private int account;
	private double balance;

	public int getAccount() {
		return account;
	}

	public void setAccount(int account) {
		this.account = account;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public static void main(String[] args) {
		CheckingAccount CA = new CheckingAccount();
		SavingsAccount SA = new SavingsAccount();
		CertificateOfDeposit CD = new CertificateOfDeposit();
		
		CA.setAccount(12345);
		CA.setBalance(8000.56);
		CA.setLimit(500.00);
		System.out.println("Your Checkin Account Number is: " + CA.getAccount() + " Balance amount is: " + CA.getBalance());
		System.out.println("Your daily limit of withdrawal is: " + CA.getLimit());
		System.out.println();
		
		SA.setAccount(98765);
		SA.setBalance(12000.00);
		System.out.println("Your Savings Account Number is: " + SA.getAccount() + " Balance amount is: " + SA.getBalance());
		System.out.println();
				
		CD.setAccount(97531);
		CD.setBalance(10000.00);
		CD.setExpiry("December 31st, 2020");
		System.out.println("Your Certificate of Deposit Number is: " + CD.getAccount() + " Balance amount is: " + CD.getBalance());
		System.out.println("Your Expiry date of CD is: " + CD.getExpiry());
		System.out.println();
	}
}
