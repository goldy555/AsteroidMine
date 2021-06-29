package softprolab;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Random;

import org.junit.jupiter.api.Test;

class AsteroidTest {

	@Test
	void testAsteroid() {
		String state;
		Random rand=new Random();
		//modify selection value to check the program flow
		int selection=5; //rand.nextInt(3);
		
		
		switch(selection) {
		case 0:
			state="normal";
			break;
		case 1:
			state="aphelion";
			break;
		case 2:
			state="perihelion";
			break;
		}
		//fail("Not yet implemented");
	}

	@Test
	void testGetCore() {
		//fail("Not yet implemented");
	}

	@Test
	void testSetCore() {
		//fail("Not yet implemented");
	}

	@Test
	void testGetDepth() {
		//fail("Not yet implemented");
	}

	@Test
	void testSetDepth(int newDepth) {
		int depth = 5;
		depth =newDepth;
		//fail("Not yet implemented");
	}

	@Test
	void testGetState() {
		//fail("Not yet implemented");
	}

	@Test
	void testSetState() {
		//fail("Not yet implemented");
	}

}
