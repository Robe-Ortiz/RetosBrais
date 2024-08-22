package battle_deadpool_wolverine;

import java.util.Random;
import java.util.Scanner;

public class Battle {
	
	private static Random random = new Random();
	private static Scanner  input = new Scanner(System.in);
	
	public static int lifeOfTheSuperheroe(SpecificSuperhero specificSuperhero) {		
        System.out.printf("Vida de %s: ",specificSuperhero);
        int superheroLife = input.nextInt();
        return superheroLife;
	}
	
	private static int attack(Superhero firstAttacker, Superhero secondAttacker, int turn) throws InterruptedException {	
		int firstAttack = firstAttacker.attack();
		System.out.printf("%s realiza un ataque de %d puntos de daño. \n",firstAttacker.getSuperHeroe(),firstAttack);
		int possibilityToAvoidSecondAttacker = random.nextInt(0,101);
		
		if(possibilityToAvoidSecondAttacker <= secondAttacker.getSuperHeroe().getDodgePercentage()) {
			System.out.printf("%s ha esquivado el ataque. \n",secondAttacker.getSuperHeroe());
			turn++;
		}else {
			secondAttacker.setLife(secondAttacker.getLife()-firstAttack<=0 ? 0 : secondAttacker.getLife()-firstAttack);
			System.out.printf("La vitalidad de %s ha bajado a %d \n",secondAttacker.getSuperHeroe(),secondAttacker.getLife());
			
			if(secondAttacker.getLife()!= 0 && firstAttack== firstAttacker.getSuperHeroe().getMaxAttack()) {				
				System.out.printf("GOLPE CRÍTICO %s QUEDA PARALIZADO. \n", secondAttacker.getSuperHeroe());
				System.out.println();

				System.out.printf("Turno %d \n",turn++);
				turn = attack(firstAttacker,secondAttacker,turn);
			}
		}
		Thread.sleep(1_000);
		return turn;
		
	}

 	public static void battle(Superhero heroOne, Superhero heroTwo) throws InterruptedException {

		System.out.printf("Comienza la batalla entre %s y %s. \n",heroOne.getSuperHeroe(),heroTwo.getSuperHeroe());
		System.out.printf("Lanzaremos una moneda para ver quien comienza, si sale cara comienza %s,"
				+ " si sale cruz comienza %s. \n",heroOne.getSuperHeroe(),heroTwo.getSuperHeroe());	
		int currency = random.nextInt(0,2);
		Superhero firstAttacker = currency==0?heroOne:heroTwo;
		Superhero secondAttacker = currency!=0?heroOne:heroTwo;
		Thread.sleep(1_000);
		System.out.printf("Ha salido %s comienza %s. \n",currency==0?"cara":"cruz",firstAttacker.getSuperHeroe());
		System.out.println();
		Thread.sleep(1_000);
		
		int turn  = 1;
		while(heroOne.getLife()>0 && heroTwo.getLife()>0) {	
			
			System.out.printf("Turno %d \n",turn++);
			turn = attack(firstAttacker,secondAttacker,turn);
			System.out.println();	
			
			if(heroOne.getLife()<=0 || heroTwo.getLife()<=0) break;	
			
			System.out.printf("Turno %d \n",turn++);
			turn = attack(secondAttacker,firstAttacker,turn);
			System.out.println();
		}
		
		System.out.printf("El ganador es %s \n",firstAttacker.getLife()==0?firstAttacker.getSuperHeroe():secondAttacker.getSuperHeroe());
	}

}