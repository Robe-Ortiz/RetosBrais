package the_rings_of_power;

public enum KindBreed implements Breed{
	PELOSOS(1),SUREÑOS_BUENOS(2),ENANOS(3),NUMENOREANOS(4),ELFOS(5);
	
	int power;
	
	private KindBreed(int power) {
		this.power = power;
	}

	public int getPower() {
		return power;
	}	
	
}
