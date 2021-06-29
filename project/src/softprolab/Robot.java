package softprolab;

public class Robot extends Traveller {
	
	//robot got hit by sunstorm
	public void HitBySunStorm() {	
		Game.RemoveRobot(this);
		this.getCurrentPosition().Remove(this);
		
	}
	
	
	//robot gets destroyed
	public void Destroyed() {
		Game.RemoveRobot(this);
	}
}
