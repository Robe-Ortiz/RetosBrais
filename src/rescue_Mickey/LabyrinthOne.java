package rescue_Mickey;

public class LabyrinthOne extends Labyrinth {

	private String[][] labyrinth = createAndConfigureLabyrinth();
	
	private String[][] wallsOfTheLabyrinth(String[][] labyrinth) {
		//column zero
		//nothing
		
		//column one
		for(int i = 0;i<labyrinth.length;i++) {
			if(i==3) continue;
			labyrinth[i][1] = "W";
		}
		
		// column two
		for(int i = 0;i<labyrinth.length;i++) {
			if(i%2 != 0) continue;
			labyrinth[i][2] = "W";
		}
		
		//column three
		//nothing
		
		//column four
		for(int i = 1; i < labyrinth.length-1;i++) {
			labyrinth[i][4] = "W";
		}
		
		//column five
		labyrinth[4][5] = "W";
		
		return labyrinth;
	}
	
	private String[][] createAndConfigureLabyrinth() {
		//Create a labyrinth of free
		String[][] labyrinth = createLabyrinth();
		
		//Choose the start and end position
		labyrinth[0][0] = "S";
		labyrinth[3][5] = "F";
		
		//Choose the Mickey Mouse position
		labyrinth[5][2] = "M";
		
		//labyrinth walls
		labyrinth = wallsOfTheLabyrinth(labyrinth);
		return labyrinth;
	}

	public String[][] getLabyrinth() {
		String[][] labyrinthCopy = labyrinth.clone();
		return labyrinthCopy;
	}

}