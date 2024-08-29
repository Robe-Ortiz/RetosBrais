package the_rings_of_power;

public enum EvilBreed implements Breed{
	SUREÑOS_MALOS(2),ORCOS(2),GOBLINS(2),HUARGO(3),TROLLS(5);
	
	int power;

	private EvilBreed(int power) {
		this.power = power;
	}

	public int getPower() {
		return power;
	}	
}
