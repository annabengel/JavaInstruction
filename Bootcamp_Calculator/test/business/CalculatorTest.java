package business;

import static org.junit.Assert.*;

import org.junit.Test;

public class CalculatorTest {

	@Test
	public void createCalcTest() {
		Calculator c1 = new Calculator(3,2);
		assertEquals(3, c1.getX());
		assertEquals(2, c1.getY());

	}
	
	@Test
	public void createAddTest() {
		Calculator c1 = new Calculator(3,2);
		c1.add();
		assertEquals(5.0 ,c1.getResult(), .0001);

	}
	
	@Test
	public void createSubtractTest() {
		Calculator c1 = new Calculator(3,2);
		c1.subtract();
		assertEquals(1.0 ,c1.getResult(), .0001);
	}
	
	@Test
	public void createMultTest() {
		Calculator c1 = new Calculator(3,2);
		c1.multiply();
		assertEquals(6.0 ,c1.getResult(), .0001);
	}
	
	@Test
	public void createDivideTest() {
		Calculator c1 = new Calculator(3,2);
		c1.divide();
		assertEquals(1.0 ,c1.getResult(), .0001);
	}
	
	@Test
	public void createModTest() {
		Calculator c1 = new Calculator(3,2);
		c1.modulus();
		assertEquals(1.0 ,c1.getResult(), .0001);
	}


}
