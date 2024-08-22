package rescue_Mickey;

import java.util.Scanner;

public class LabyrinthForThePlayer extends Labyrinth {

	private static Scanner scan = new Scanner(System.in);
	private String[][] labyrinthForThePlayer = createLabyrinth();
	private LabyrinthOne labyrinthOne = new LabyrinthOne();

	private String choosePlayerLetter() {
		String letter = "DEFAULT";
		while (letter.length() != 1) {
			System.out.print("Escribe la letra,número o símbolo con el que quieres jugar: ");
			letter = scan.nextLine();
		}
		return letter;
	}

	private void mickeyMessage(Boolean mickyRescued) {
		if (mickyRescued) {
			System.out.printf("\u001B[32m" + "\nMickey ya está contigo. Encuentra la salida.\n" + "\u001B[0m");
		} else {
			System.out.printf("\u001B[31m" + "\nAún tienes que encontrar a Mickey para salvarlo.\n" + "\u001B[0m");
		}
		System.out.println();
	}

	private String translateMove(String spanishMove) {
		if (spanishMove.equalsIgnoreCase("left") || spanishMove.equalsIgnoreCase("right")
				|| spanishMove.equalsIgnoreCase("top") || spanishMove.equalsIgnoreCase("bottom"))
			return spanishMove;

		String englishMove = "STOP";
		if (spanishMove.equalsIgnoreCase("izquierda"))
			englishMove = "LEFT";
		if (spanishMove.equalsIgnoreCase("derecha"))
			englishMove = "RIGHT";
		if (spanishMove.equalsIgnoreCase("arriba"))
			englishMove = "TOP";
		if (spanishMove.equalsIgnoreCase("abajo"))
			englishMove = "BOTTOM";
		return englishMove;
	}

	// print limit message
	private void outOfIndexMessage() {
		System.out.println("\u001B[33m" + "NO PUEDES AVANZAR. LÍMITE DEL LABERINTO." + "\u001B[0m");
	}

	//print obstacle message
	private void wallOnTheWayMessage() {
		System.out.println("\u001B[33m" + "NO PUEDES AVANZAR. MURO DELANTE." + "\u001B[0m");
	}

	//checks that the movement is correct
	private Movements playerSelectedMove() {
		Movements move = Movements.STOP;
		Boolean needToSelectMovement = true;
		do {
			System.out.print("Escribe la dirección en la que quieres moverte (IZQUIERDA,DERECHA,ARRIBA,ABAJO): ");
			try {
				move = Movements.valueOf(translateMove(scan.nextLine().toUpperCase()));
				needToSelectMovement = false;
			} catch (IllegalArgumentException e) {
				System.out.println("Movimiento no válido");
			}
		} while (needToSelectMovement);
		return move;
	}

	private boolean moveRight(int playerRow, int playerColumn, String playerLetter, boolean mickeyFound) {
		if (playerColumn + 1 == labyrinthForThePlayer[playerRow].length) {
			outOfIndexMessage();
			return false;
		}

		if (labyrinthOne.getLabyrinth()[playerRow][playerColumn + 1] == " " || labyrinthOne.getLabyrinth()[playerRow][playerColumn + 1] == "?") {
			labyrinthForThePlayer[playerRow][playerColumn] = " ";
			labyrinthForThePlayer[playerRow][playerColumn + 1] = playerLetter;
		}else if (labyrinthOne.getLabyrinth()[playerRow][playerColumn + 1] == "M") {
			if(mickeyFound) return false;
			else {
				labyrinthForThePlayer[playerRow][playerColumn] = " ";
				labyrinthForThePlayer[playerRow][playerColumn + 1] = playerLetter;
				return true;
			}
		}else{
			wallOnTheWayMessage();
		}
		return false;
	}

	private boolean moveBottom(int playerRow, int playerColumn, String playerLetter, boolean mickeyFound) {
		if (playerRow + 1 == labyrinthForThePlayer.length) {
			outOfIndexMessage();
			return false;
		}

		if (labyrinthOne.getLabyrinth()[playerRow + 1][playerColumn] == " " || labyrinthOne.getLabyrinth()[playerRow + 1][playerColumn] == "?") {
			labyrinthForThePlayer[playerRow][playerColumn] = " ";
			labyrinthForThePlayer[playerRow + 1][playerColumn] = playerLetter;
		}else if (labyrinthOne.getLabyrinth()[playerRow + 1][playerColumn] == "M") {
			if(mickeyFound) return false;
			else {
				labyrinthForThePlayer[playerRow][playerColumn] = " ";
				labyrinthForThePlayer[playerRow + 1][playerColumn] = playerLetter;
				return true;
			}
			
		}else if(labyrinthOne.getLabyrinth()[playerRow + 1][playerColumn] == "F") {
			if(mickeyFound) {
				System.out.println("Has conseguido escapar.");
				return true;
			}else {
				labyrinthForThePlayer[playerRow][playerColumn] = " ";
				labyrinthForThePlayer[playerRow + 1][playerColumn] = playerLetter;
			}			
		}else {
			wallOnTheWayMessage();
		}
		return false;
	}

	private boolean moveLeft(int playerRow, int playerColumn, String playerLetter, boolean mickeyFound) {
		if (playerColumn - 1 < 0) {
			outOfIndexMessage();
			return false;
		}
		if (labyrinthOne.getLabyrinth()[playerRow][playerColumn - 1] == " " || labyrinthOne.getLabyrinth()[playerRow ][playerColumn - 1] == "?") {
			labyrinthForThePlayer[playerRow][playerColumn] = " ";
			labyrinthForThePlayer[playerRow][playerColumn - 1] = playerLetter;
			return false;
		}else if (labyrinthOne.getLabyrinth()[playerRow][playerColumn - 1] == "M") {
			labyrinthForThePlayer[playerRow][playerColumn] = " ";
			labyrinthForThePlayer[playerRow][playerColumn - 1] = playerLetter;
			if(mickeyFound) return false;
			return true;
			
		}else{
			wallOnTheWayMessage();
			return false;
		}
	}

	private boolean moveTop(int playerRow, int playerColumn, String playerLetter, boolean mickeyFound) {
		if (playerRow - 1 < 0) {
			outOfIndexMessage();
			return false;
		}
		if (labyrinthOne.getLabyrinth()[playerRow - 1][playerColumn] == " " || labyrinthOne.getLabyrinth()[playerRow - 1][playerColumn] == "?") {
			labyrinthForThePlayer[playerRow][playerColumn] = " ";
			labyrinthForThePlayer[playerRow - 1][playerColumn] = playerLetter;
		}else if (labyrinthOne.getLabyrinth()[playerRow  - 1][playerColumn] == "M") {
			if(mickeyFound) return false;
			else {
				labyrinthForThePlayer[playerRow][playerColumn] = " ";
				labyrinthForThePlayer[playerRow  - 1][playerColumn] = playerLetter;
				return true;
			}
		}else{
			wallOnTheWayMessage();
		}
		return false;
	}

	private int findRowPlayer(String playerLetter) {
		for (int i = 0; i < labyrinthForThePlayer.length; i++) {
			for (int j = 0; j < labyrinthForThePlayer[i].length; j++) {
				if (labyrinthForThePlayer[i][j] == playerLetter) {
					return i;
				}
			}
		}
		return 0;
	}

	private int findColumnPlayer(String playerLetter) {
		for (int i = 0; i < labyrinthForThePlayer.length; i++) {
			for (int j = 0; j < labyrinthForThePlayer[i].length; j++) {
				if (labyrinthForThePlayer[i][j] == playerLetter) {
					return j;
				}
			}
		}
		return 0;
	}

	//make the movement
	private boolean playerMove(Movements playerSelectMove, String playerLetter, boolean mickeyFound) {
		int playerRow = findRowPlayer(playerLetter);
		int playerColumn = findColumnPlayer(playerLetter);
		if (playerSelectMove == Movements.RIGHT)
			return moveRight(playerRow, playerColumn, playerLetter,mickeyFound);
		if (playerSelectMove == Movements.BOTTOM)
			return moveBottom(playerRow, playerColumn, playerLetter, mickeyFound);
		if (playerSelectMove == Movements.LEFT)
			return moveLeft(playerRow, playerColumn, playerLetter,mickeyFound);
		if (playerSelectMove == Movements.TOP)
			return moveTop(playerRow, playerColumn, playerLetter,mickeyFound);

		return false;
	}

	// print rules of the game
	public void rules() {
		try {
			System.out.println("Bienvenido al laberinto de Maléfica");
			Thread.sleep(2_000);
			System.out.println(
					"Tu misión se divide en dos pasos, primero encontrar a Mickey Mouse y después encontrar la salida");
			Thread.sleep(4_000);
			System.out.println("Disneyland cuenta contigo para rescatar a Mickey Mouse");
			Thread.sleep(3_000);
			System.out.println();
		} catch (InterruptedException e) {
			e.getMessage();
		}
	}

	// print final joke message in the game
	private void finalJokeMessage() {
		System.out.println("\u001B[36m" + "! HAS CONSEGUIDO RESCATAR A MICKEY," + "\u001B[35m" + " ESTÁS INVITADO A DISNEYLAND PARÍS" + "\u001B[33m" + "  A GASTOS PAGADOS !" + "\u001B[0m");
		System.out.print("Introduce el año en el cual quieres canjear tú premio: ");
		String falseAward = scan.nextLine();
		while(true) {
			System.out.printf("Lo sentimos no tenemos fecha disponible para el año %s, introduce otra fecha: ",falseAward);
			falseAward = scan.nextLine();
		}
	}
	
	// this method start the game
	public void game() {
		Boolean exitFound = false;
		Boolean mickyFound = false;
		int turn = 1;
		String playerLetter = choosePlayerLetter();
		labyrinthForThePlayer[0][0] = playerLetter;
		showLabyrinth(labyrinthForThePlayer);
		while (!mickyFound) {
			System.out.println("MOVIMIENTO NÚMERO " + turn++);
			mickyFound = playerMove(playerSelectedMove(), playerLetter,mickyFound);
			showLabyrinth(labyrinthForThePlayer);
			mickeyMessage(mickyFound);
		}
		
		while(!exitFound) {
			System.out.println("MOVIMIENTO NÚMERO " + turn++);
			exitFound = playerMove(playerSelectedMove(), playerLetter,mickyFound);
			showLabyrinth(labyrinthForThePlayer);
			mickeyMessage(mickyFound);
		}
		
		finalJokeMessage();
	}

	public String[][] getLabyrinthForThePlayer() {
		return labyrinthForThePlayer;
	}

}
