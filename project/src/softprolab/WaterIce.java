package softprolab;

public class WaterIce extends Mineral{

	//water sublimates while being mined in perihelion
	public void sublimate() throws Throwable {
		this.finalize();
	}

	@Override
	public int getType() {
		return 2;
	}

	@Override
	public void explodeAsteroid() {
		// TODO Auto-generated method stub
		
	}
}
