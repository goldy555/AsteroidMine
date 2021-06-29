package softprolab;

import java.util.ArrayList;
import java.util.List;

public abstract class Place {
	protected ArrayList <Place> places ;
	protected ArrayList <Traveller> travellers;
	//public Identity ID;	
	public int ID;
	//traveller hidden in Asteroid
		public Traveller hiddenTraveller;
	
	//adding traveller to the place 
	public void Accept(Traveller o) {
		travellers.add(o);
	};
	
	//removing traveller from place
	public void Remove(Traveller o) {
		for(int i=0; i<travellers.size(); i++) 
		{
			//if element o is found in the list, then remove it
			if(travellers.get(i)==o)
			{ 
				travellers.remove(i); 
				o.SetCurrentPlace(null);
				break;
				}
		}
	};
	
	//getting list of neighboors
	public List<Place> GetNeighbor() {
		return places;		
	};
	
	//add place to list
	public void setNeighbor(Place p) {
		places.add(p);
	};
	
	

}
