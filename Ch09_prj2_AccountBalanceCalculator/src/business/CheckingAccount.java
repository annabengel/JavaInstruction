package business;

public class CheckingAccount extends Account { 
	
	//add instance variable
	private double monthlyFee;

	// since Account has constructor, CheckingAccount needs constructor
	public CheckingAccount(double balance, double monthlyFee) {
		super(balance);
		this.monthlyFee = monthlyFee;
	}

	public double getMonthlyFee() {
		return monthlyFee;
	}
	
	public void subtractMonthlyFee() {
		balance -= monthlyFee;
		
	}

}
