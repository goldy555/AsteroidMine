package softprolab;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class GameTest {

	@Test
	void testRun() {
	    Boolean working = true;
		long pastTime=  541939656;
		long pastmilTime = System.currentTimeMillis();
		final double FPS= 60;
		final double optimalFps= (1000000000D / FPS);
		int frames=0;
		double alpha =0;
		int update =0;
		while (working) {
			long presentTime = 441939656;
			double updateTime = (presentTime - pastTime)/optimalFps;
			alpha += updateTime;
			pastTime = presentTime;
			while (alpha>=1) {
			update++;
			alpha--;
		//	tick(); // calling tick function which update objects
			}
			
			frames++;
			if (System.currentTimeMillis()-pastmilTime>1000) {
			pastmilTime+=1000;
     		//System.out.println("Frames"+frames+" "+"tics"+update+" ");
			frames=0;
			update=0;

			}

			}
		
		//fail("Not yet implemented");
	}

}
