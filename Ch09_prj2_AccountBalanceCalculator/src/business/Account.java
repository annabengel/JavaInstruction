package business;

public class Account implements Balanceable, Withdrawable, Depositable {

	protected double balance; // balance instance variable, needed for the return in getBalance
	
	//constructor that accepts the balance
	public Account(double balance) {
		super();
		this.balance = balance;
	} 

	@Override // adds deposit amount to balance
	public void deposit(double amount) {
		balance += amount;

	}

	@Override // withdraw - subtracting amount from balance 
	public void withdraw(double amount) {
		balance -= amount;

	}

	@Override
	public double getBalance() {
		return balance;
	}

	@Override // setting balance as amount
	public void setBalance(double amount) {
		balance = amount; 

	}

}
