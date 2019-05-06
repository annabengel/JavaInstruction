package business;

public class SavingsAccount extends Account {
	
	private double monthlyInterestRate;
	private double monthlyInterestPayment;
	
	public SavingsAccount(double balance, double monthlyInterestRate) {
		super(balance);
		this.monthlyInterestRate = monthlyInterestRate;
	}
	
	//formula: monthlyInterestPayment = balance * monthlyInterestRate 
	//no return, just adding payment back to balance
	public void applyMonthlyPayment() {
		monthlyInterestPayment = balance * monthlyInterestRate;
		balance += monthlyInterestPayment; 
		
	}
	
	public double getMonthlyInterestPayment() {
		return monthlyInterestPayment;
	}
	
	

}
