package Assignment6;

public class BankAccount {
	private double balance;
	public BankAccount() {
		balance = 0.0;
	}
	public BankAccount(double initialBalance) {
		balance = initialBalance;
	}
	public void deposit(double amount) {  
		balance += amount;
	}
	public void withdraw(double amount) { 
		balance -= amount;
	}
	public double getBalance() {   
		return balance;
	}
	public static void main(String[] args){
		double[] test1 ={1.0, 2.0, 32.0, 99.0, 45.0,95.0, 7.0};
		LevelThree test1a = new LevelOne(test1);
		LevelThree test1b = new LevelTwo(test1);
		LevelThree test1c = new LevelThree(test1);
		System.out.println(test1a.measure());
		System.out.println(test1b.measure());
		System.out.println(test1c.measure());
	}
}