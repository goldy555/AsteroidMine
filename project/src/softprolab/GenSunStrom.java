package softprolab;


import java.util.LinkedList;
import java.util.Random;

public class GenSunStrom {

	Game g;
	SunStorm sss;
	Random r = new Random();
	public LinkedList<Asteroid> ast = new LinkedList<Asteroid>();
	void strom() {
		
		int i = r.nextInt(ast.size()-1);
		this.ast = (LinkedList<Asteroid>) g.aster;
		sss= g.ss;
		//getting position of a random asteroid
		Place c = ast.get(i);
		//assigning sunstrom the position of that random asteroid
		sss.setCurrentPosition((Place) c.GetNeighbor());
	}
}
