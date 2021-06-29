package softprolab;

public class Uranium extends Mineral{
	//uranium explodes asteroid while being mined during perihelion
	public void explodeAsteroid() {
		Game.EndGame();
	}

	@Override
	public int getType() {
		return 1;
	}

	@Override
	public void sublimate() throws Throwable {
		// TODO Auto-generated method stub
		
	}
}
