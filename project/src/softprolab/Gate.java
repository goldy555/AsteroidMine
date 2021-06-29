package softprolab;

import java.util.ArrayList;

public class Gate extends Place{
	
	//pair of the gate
	private Gate pair;
	//whether gate is active (deployed) or nonactive(not deployed, damaged etc.)
	public boolean active;
	private Asteroid a;

	//constructor
	Gate(int id)
	{
		this.places=new ArrayList<Place>();
		this.travellers=new ArrayList<Traveller>();
		this.ID=id;
		active=false;
	}
	
	//teleport traveller to pair if gates are active
	public void Teleport(Traveller o) {		
		if(this.active==true&&this.pair.active==true) {
			o.Travel(this.pair.a);
		}
	}
	
	//returns pair
	public Gate getPair() {
		return this.pair;
	}
	
	//after second gate of pair is created, they get paired
	public void setPair(Gate g) {	
		this.pair=g;		
	}
	
	//gate got hit by sun storm and become unactive
	public void HitBySunStrom() {	
		this.active=false;
	}
	
	
	
	
	
}
