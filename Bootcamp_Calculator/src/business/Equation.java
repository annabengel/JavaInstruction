package business;

public class Equation {
	
	protected double x;
	protected double y;
	
	public Equation() {
		super();
	}
	
	public Equation(double x, double y) {
		super();
		this.x = x;
		this.y = y;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	// REVIEW!! 
	@Override
	public String toString() {
		return "Equation [x=" + x + ", y=" + y + "]";
	}
	
	

}
