package softprolab;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class SettlerTest {

	@Test
	void testBuildRobot() {
	//	Mineral obj = new Mineral();
		ArrayList<Mineral> minerals = new ArrayList<Mineral>();
		boolean ironFound = false;
		boolean carbonFound = false;
		boolean uraniumFound = false;
		for(Mineral mineral: minerals){
			if(!ironFound && mineral instanceof Iron) { ironFound =true;}
		
			else if(!carbonFound && mineral instanceof Carbon) { carbonFound =true;}

			else if(!uraniumFound && mineral instanceof Uranium) { uraniumFound = true;}

			else break;
		}
		
		if( ironFound && carbonFound && uraniumFound){
			for(Mineral mineral : minerals){
				if(mineral instanceof Iron) {minerals.remove(mineral); break;}
			}
			for(Mineral mineral : minerals){
				if(mineral instanceof Carbon) {minerals.remove(mineral); break;}
			}
			for(Mineral mineral : minerals){
				if(mineral instanceof Uranium) {minerals.remove(mineral); break;}
			}
		}
		//this.GetCurrentPlace().Accept(new Robot());
	}

}
