package battle_deadpool_wolverine;

import java.util.Random;


public class Superhero {	
	private SpecificSuperhero superHeroe;
	private int life;
	private static Random random = new Random();	
	
	public Superhero(SpecificSuperhero superHeroe, int life){
		this.superHeroe = superHeroe;
		this.life = life;
	}

	public SpecificSuperhero getSuperHeroe() {
		return superHeroe;
	}

	public int getLife() {
		return life;
	}
	
	public void setLife(int life) {
		this.life = life;
	}
	
	public int attack() {		
		return random.nextInt(superHeroe.getMinAttack(), superHeroe.getMaxAttack()+1);
	}
}

enum SpecificSuperhero{
	DEADPOOL(25,10,100),WOLVERINE(20,10,120);	
	private int dodgePercentage;
	private int minAttack;
	private int maxAttack;
	
	private SpecificSuperhero(int dodgePercentage, int minAttack, int maxAttack) {
		this.dodgePercentage = dodgePercentage;
		this.minAttack = minAttack;
		this.maxAttack = maxAttack;
	}
	
	public int getDodgePercentage() {
		return dodgePercentage;
	}

	public int getMinAttack() {
		return minAttack;
	}

	public int getMaxAttack() {
		return maxAttack;
	}	
}
