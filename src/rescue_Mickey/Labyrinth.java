package rescue_Mickey;

public abstract class Labyrinth {

	private String[][] labyrinth = createLabyrinth();
	
	protected String[][] createLabyrinth() {
		String[][] labyrinth = new String[6][6];
		//Create a labyrinth of free
		for(int i = 0; i < labyrinth.length;i++) {
			for(int j = 0; j < labyrinth[i].length;j++) {
				labyrinth[i][j] = " ";
			}
		}
		return labyrinth;
	}
	
	protected static void showLabyrinth(String[][] labyrinth) {
		for(String[] row :labyrinth) {
			for(String cell : row) {
				System.out.print(cell+" ");
			}
			System.out.println();
		}
	}

	public String[][] getLabyrinth() {
		return labyrinth;
	}
	
	
}
