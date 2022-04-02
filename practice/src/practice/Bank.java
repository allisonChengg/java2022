package practice;

public class Bank {
	
	private double balance;
	
	public Bank(double amount) {
		balance = amount;
	}
	
	public void transfer(Bank bank, double amount) {
		bank.balance += amount;
		balance -= amount;
	}
	
	public String toString() {
		 return "" + balance;
	}
	
	public static void main(String[] args) {

		Bank tom = new Bank(2500.0);
		Bank sue = new Bank(4000.0);
		tom.transfer(sue, 1400.0);
		System.out.println(tom);
		System.out.println(sue);
	}

}
