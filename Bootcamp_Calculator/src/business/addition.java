package business;

public class addition extends Equation {

	public double sum;

	public addition() {
		super();
	}

	public addition(double x, double y, double sum) {
		super(x, y);
		this.sum = sum;
	}

	public double getSum() {
		sum = x + y;
		return sum;
	}

	public void setSum(double sum) {
		this.sum = sum;
	}

	@Override
	public String toString() {
		return "addition [sum=" + sum + "]";
	}
	
	
		
}
