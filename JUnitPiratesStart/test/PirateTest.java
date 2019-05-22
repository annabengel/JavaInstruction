import static org.junit.Assert.*;

import org.junit.Test;

public class PirateTest {

	@Test
	public void createPirateTest() {
		Pirate p1 = new Pirate("Patchy");
		assertEquals("Patchy", p1.getName()); // asserting that something will be equal to what you expect it to be
		assertEquals(4, p1.getLimbsRemaining());
		
	}
	
	@Test
	public void createOctoPirateTest() {
		Pirate p1 = new Pirate ("Octo Pete", 8);
		assertEquals("Octo Pete", p1.getName());
		assertEquals(8, p1.getLimbsRemaining());
		assertEquals(0, p1.getTotalLimbsLost());
	}
	
	@Test
	public void createIsDeadTest() {
		Pirate p1 = new Pirate ("PirateSteve");
		assertFalse(p1.isDead());
	}
	
	@Test(timeout=27) // in milliseconds; if the app takes longer than 1000 ms to run/execute, 
	// it will end, telling you there is an error
	public void timeoutTest() {
		for (int i = 0; i < 1000; i++) {
			Pirate p = new Pirate("DreadPirate"+i);
			System.out.println(p);
		}
		
	}

}
