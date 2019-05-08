package business;

public class Calculator {
	
	private int x;
	private int y;
	private double result;

	
	public Calculator() {
		super();
	}

	public Calculator(int x, int y) {
		super();
		this.x = x;
		this.y = y;
		this.result = 0.0;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public double getResult() {
		return result;
	}

	public void setResult(double result) {
		this.result = result;
	}

	public double modulus() {
		result = x % y;
		return result;
	}

	public double divide() {
		result = x / y;
		return result;
	}

	public double multiply() {
		result = x * y;
		return result;
	}

	public double subtract() {
		result = x - y;
		return result;
	}

	public double add() {
		result = x + y;
		return result;
	}

	@Override
	public String toString() {
		return "Calculator [x=" + x + ", y=" + y + ", result=" + result + "]";
	}
	
	

}
