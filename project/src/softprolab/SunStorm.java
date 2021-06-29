package softprolab;

import java.awt.List;
import java.util.LinkedList;

public class SunStorm extends Place {
		Place p;
	LinkedList <Traveller> te;
	Game g;
	//sun storm destroys traveler
	public void Destroy(LinkedList <Traveller> t) {
		
		this.te = t;
	//in case the traveller object type is settler the following function will execute 
		for(int i=0; i<te.size(); i++) {
		if (te.get(i).GetID() == Identity.SETTLER ) {
			if (te.get(i).getCurrentPosition() == g.ss.getCurrentPosition(p) ) {
				
				try {
					te.get(i).HitBySunStorm();
				} catch (Throwable e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
		// in case object type is robot
		else if (te.get(i).GetID() == Identity.ROBOT ) {
			
			if (te.get(i).getCurrentPosition() == g.ss.getCurrentPosition(p) ) {
				try {
					te.get(i).HitBySunStorm();
				} catch (Throwable e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		
	}
	}
	}
	
	//sun storm destroys gate
	public void Destroy(Gate gate) {
		//similarly if from all the traveller type object the type is of Gate following function will execute
		for(int i=0; i<te.size(); i++) {
			if (te.get(i).GetID() == Identity.GATE ) {
				if (te.get(i).getCurrentPosition() == g.ss.getCurrentPosition(p) ) {
					
					try {
						te.get(i).HitBySunStorm();
					} catch (Throwable e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
			}
			
		
	}
		
	}
	public Place getCurrentPosition(Place p) {
		return p;
		
	}
public void setCurrentPosition( Place p) {
	
		this.p =p;
		
	}


	
}
