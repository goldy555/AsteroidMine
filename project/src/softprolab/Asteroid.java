package softprolab;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Asteroid extends Place {

	
	protected ArrayList <Asteroid> places;
	
	//state of asteroid : normal. aphelion, perihelion
	private String state;
	
	//depth of mantle in units
	private int depth;
	
	//whether core is hollow or not
	boolean hollow;
	
	//which mineral asteroid contains if there's any
	private Mineral mineralCore;
	
	//list of minerals on the surface
	public List<Mineral> mineralsSurface;
	
	

	
	//constructor
	Asteroid(int id)
	{
		this.places=new ArrayList<Asteroid>();
		this.travellers=new ArrayList<Traveller>();
		this.ID=id;
		Random rand=new Random();
		int selection=rand.nextInt(3);
		//which state
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
		//assigning depth in range 1=7
		int newd=rand.nextInt(7);
		depth=newd+1;
		//randomly choosing if hollow or not
		int news=rand.nextInt(100);
		if(news%5==0) 
		{
			hollow=true;
		}
		else {hollow=false;}
		
		//if it's not hollow, assigning an mineral
		if(hollow==false) 
		{
			
			int newss=rand.nextInt(4);
			//assigning mineral based on random number
			switch(newss) {
			case 0:
				//System.out.println("core");
				Carbon c=new Carbon();
				//this.mineralCore=new Carbon();
				this.setCore(c);
				break;
			case 1:
				//System.out.println("core1");
				Iron i=new Iron();
				this.setCore(i);
				//this.mineralCore=new Carbon();
				break;
			case 2:
				//System.out.println("core2");
				Uranium u=new Uranium();
				this.setCore(u);
				//this.mineralCore=new Carbon();
				break;
			case 3:
				
				WaterIce w=new WaterIce();
				//System.out.println(w.id);
				this.setCore(w);
				//this.mineralCore=new Carbon();
				break;
			}
		}
		
		
	}
	
	public Mineral getCore() {
		return mineralCore;
	}
	
	//sets core
	public void setCore(Mineral mi) {
		this.mineralCore=mi;	
	}
	
	//returns depth
	public int getDepth() {
		return depth;	
	}
	
	//sets depth
	public void setDepth(int newDepth) {
		this.depth = newDepth;	
		}
	
	//returns state
	public String getState() {		
		return state;
	}
	
	//sets state
	public void setState(String newState) {
		this.state=newState;
	}
	
	//exploding due to mining of uranium at perihelion state
	public void Explode() {
		//checks every traveller on surface 
		for(int i=0; i<travellers.size(); i++) {
			//if it's robot then transfers it to first neighbor
			if(travellers.get(i) instanceof Robot) {
				//travellers.get(i).Travel(this.GetNeighbor().get(0));
			}
			//if it's settler then it dies
			else {
				try {
					travellers.get(i).Destroyed();
				} catch (Throwable e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
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
		public List<Asteroid> getNeighbor() {
			return places;		
		};
		
		//add place to list
		public void setNeighbor(Asteroid p) {
			places.add(p);
		};
}
