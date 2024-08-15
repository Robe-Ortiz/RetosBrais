package battle_deadpool_wolverine;



public class Main {
	
	
	public static void main(String[] args) {	
		//User select life for the superheros
		int deadpoolLife = Battle.lifeOfTheSuperheroe(SpecificSuperhero.DEADPOOL);
		int wolverineLife =Battle.lifeOfTheSuperheroe(SpecificSuperhero.WOLVERINE);
		
		//Create the superheros
		Superhero deadpool = new Superhero(SpecificSuperhero.DEADPOOL,deadpoolLife);
		Superhero wolverine = new Superhero(SpecificSuperhero.WOLVERINE,wolverineLife);
		
		//Superhero fighting
		try {
			Battle.battle(deadpool, wolverine);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}		
	}
}
