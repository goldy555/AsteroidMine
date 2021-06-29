package softprolab;


//can be settler or robot
public class Traveller {
	Identity Id;
	
	//current location of traveller
	protected Asteroid currentPlace;
	
	//traveller is hit by sun storm
	public void HitBySunStorm() throws Throwable {
		this.Destroyed();
	}
	
	//traveller drills mantle by one unit
	public void Drill(Asteroid a) {
		int newDepth=a.getDepth()-1;
		
		a.setDepth(newDepth);
		
	}
	
	//traveller travels to place object
	public void Travel(Asteroid place) {
		//this.GetCurrentPlace().Remove(this);
		//p.Accept(this);
		this.SetCurrentPlace(place);
		
	}
	
	//traveller hides in the core of hollow asteroid
	public void Hide() {
		if(this.GetCurrentPlace() instanceof Asteroid) 
		{
			this.GetCurrentPlace().hiddenTraveller=this;
		}
	}
	
	//traveller is destroyed
	public void Destroyed() throws Throwable {
		this.finalize();
	}
	public Identity GetID() {
		return Id;		
	}
	
	
	//returns current place
public Asteroid GetCurrentPlace() {
		
		return currentPlace;
	}
	
	//
	public void SetCurrentPlace(Asteroid p) {
		this.currentPlace = p;
	}
	
	public Asteroid getCurrentPosition() {
		return currentPlace;	
	}
}
