package the_rings_of_power;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class BattleBetweenKindBreedAndEvilBreed {
	private static Random random = new Random();
	private static Scanner input = new Scanner(System.in);
	private List<KindBreed> armyOfTheKindBreed = new ArrayList<>();
	private List<EvilBreed> armyOfTheEvilBreed = new ArrayList<>();	
	
	//check if the number of warriors is correct
	private int checkNumberOfWarriors(String numberOfWarriorsString) {
		Integer numberOfWarriorsInteger = 0;
		try {
			numberOfWarriorsInteger = Integer.parseInt(numberOfWarriorsString);
		}catch (NumberFormatException e) {
			System.out.print("Sólo puedes introducir números, porfavor introduzca uno: ");
			return requestNumberOfWarriors();
		}
		
		if(numberOfWarriorsInteger <= 0) {
			System.out.print("Por favor, introduzca un valor mayor que 0: ");
			return requestNumberOfWarriors();
		}
		return numberOfWarriorsInteger;
	}
		
	// request number of warriors of the army of kindly breed
	private int requestNumberOfWarriors() {	
		String numberOfWarriorsString = input.nextLine();		
		return checkNumberOfWarriors(numberOfWarriorsString);
	}
	
	// create an army of kindly breed and select number of warriors
	private <Breed extends Enum<Breed>> List<Breed> createBreedList(int warriorsNumber, Class<Breed> typeOfBreed){
		List<Breed> breedList = new ArrayList<>();
		Breed[] warriorsBreed = typeOfBreed.getEnumConstants();
		for(int i = 0; i < warriorsNumber; i++) {
				breedList.add(warriorsBreed[random.nextInt(warriorsBreed.length)]);
		}
		return breedList;
	}
	
	//information on the number of warriors and total score
	private void displayBattleInformation(int totalPointKindBreed, int totalPointEvilBreed) {
		System.out.printf("El ejercito bondadoso ha contado con %d efectivos con una puntuación total de %d \n"
				,armyOfTheKindBreed.size(),totalPointKindBreed);
		System.out.printf("El ejercito malvado ha contado con %d efectivos con una puntuación total de %d \n"
				,armyOfTheEvilBreed.size(),totalPointEvilBreed);
	}
	
	//result of the confrontation between kindBreed and EvilBreed
	private void resultToBattleBetweenKindBreedAndEvilBreed(List<KindBreed> armyOfTheKindBreed, List<EvilBreed> armyEvilBreed) {
		 int totalPointKindBreed = armyOfTheKindBreed.stream().mapToInt(c->c.getPower()).sum();
		 int totalPointEvilBreed = armyEvilBreed.stream().mapToInt(c->c.getPower()).sum();
		 
		 if (totalPointKindBreed == totalPointEvilBreed) System.out.println("¡ Empate !");
		 else System.out.printf("El ejercito vencedor ha sido el ejercito de los guerreros %s\n",
				 totalPointKindBreed>totalPointEvilBreed?"bondadosos. \nLARGA VIDA A FRODO":"malvados. \nLARGA VIDA A SAURON");	
		 
		 displayBattleInformation(totalPointKindBreed, totalPointEvilBreed);
	}


	
	//method to perform the battle
	public void battle() {
		System.out.print("Introducir número de guerreros bondadosos:");
		this.armyOfTheKindBreed = createBreedList(requestNumberOfWarriors(),KindBreed.class);
		System.out.print("Introducir número de guerreros malvados:");
		this.armyOfTheEvilBreed = createBreedList(requestNumberOfWarriors(),EvilBreed.class);		

		resultToBattleBetweenKindBreedAndEvilBreed(armyOfTheKindBreed, armyOfTheEvilBreed);		

	}
	
}
