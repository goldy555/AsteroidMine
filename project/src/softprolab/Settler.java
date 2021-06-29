package softprolab;
import java.util.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;  



public class Settler extends Traveller{
		
	//public static boolean finish = false;
	//inventory
	 ArrayList<Mineral> minerals;
	
	//inventory
	private ArrayList<Gate> gates;

	public Settler() {
		this.minerals=new ArrayList<Mineral>();
	}
	
	//settler mines asteroid
	public void Mine(Asteroid a) throws Throwable {
		if(a.getDepth()==0 || !a.hollow){
			if(a.getCore() instanceof Uranium && a.getState().equals("perihelion")){
				a.getCore().explodeAsteroid();
			}
			else if(a.getCore() instanceof WaterIce && a.getState().equals("perihelion")){
				a.getCore().sublimate();
				a.setCore(null);
				GameScreen newscreen=new GameScreen(this);
			}
			else {
			if(minerals.size()<10){
		   minerals.add(a.getCore());}
			else {a.mineralsSurface.add(a.getCore());}
			a.hollow=true;
			GameScreen newscreen=new GameScreen(this);
			}
		}
	}
	
	//settler builds robot using minerals
	public void BuildRobot() {
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
		this.GetCurrentPlace().Accept(new Robot());
	}
	
	//settler is hit by sun storm
	public void HitBySunStorm() {	
		this.GetCurrentPlace().Remove(this);
	}
	
	public void Destroyed() throws Throwable {
		this.Die();
	}
	
	//settler builds pair of teleportation gates
	public void BuildGate(int Id) {
		boolean ironFound = false;
		int unitOfIron =0;
		boolean waterFound = false;
		boolean uraniumFound = false;
		for(Mineral mineral: minerals){
			if(!ironFound && mineral instanceof Iron) { 
				unitOfIron++;
				if(unitOfIron==2) {ironFound =true;}
		
			else if(!waterFound && mineral instanceof WaterIce) { waterFound =true;}

			else if(!uraniumFound && mineral instanceof Uranium) { uraniumFound = true;}

			else break;
		}
		
		if( ironFound && waterFound && uraniumFound){
			for(Mineral mineral2 : minerals){
				if(mineral instanceof Iron) {
					minerals.remove(mineral2); 
					unitOfIron--;
					if(unitOfIron==0) { break;}
			}
			for(Mineral mineral1 : minerals){
				if(mineral1 instanceof WaterIce) {minerals.remove(mineral); break;}
			}
			for(Mineral mineral1 : minerals){
				if(mineral1 instanceof Uranium) {minerals.remove(mineral); break;}
			}
		}
		gates.add(new Gate(Id));
	}}}
	
	//settler dies
	public void Die() {
		this.GetCurrentPlace().Remove(this);
		JFrame frame=new JFrame();
		JPanel panel=new JPanel();
		JTextArea text=new JTextArea("You Lost! You may exit!");
		panel.add(text);
		frame.add(panel);
		frame.pack();
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
	//settler makes station and wins
	public void MakeStation() {
		Game.winGame();
	}
	
	//settler hides mineral in the core of hollow asteroid
	public void FillWithMineral(Asteroid a, Mineral m) {
		a.setCore(m);
		minerals.remove(m);
	}
	
	//we will add the new gate to gates list in BuildGate function so we don't need SetGates function
	public ArrayList<Gate> GetGates(){
		return gates;
	}
	
	//we will add the new mineral to the minerals list in the Mine function so we don't need SetMinerals function
	public ArrayList<Mineral> GetMinerals(){
		return minerals;
	}
	
	public void addMinerals(Mineral m){
		minerals.add(m);
	}

	//settler deploys gate
	public void DeployGate(Gate g, Asteroid p) {
		gates.remove(g);
		this.SetCurrentPlace(p);
	}
	
	public Asteroid GetCurrentPlace() {
		
		return currentPlace;
	}
	
	public void SetCurrentPlace(Asteroid p) {
		this.currentPlace = p;
	}
}
