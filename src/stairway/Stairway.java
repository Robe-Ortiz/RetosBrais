package stairway;

public class Stairway {

	public void printStairway(int number) {
		if (number == 0) {
			zeroNumber();
		} else if (number > 0) {
			positiveNumber(number);
		} else {
			negativeNumber(number);
		}

	}

	private void positiveNumber(int number) {
		System.out.println("  ".repeat(number) + " _");
		for(int i = number; i>0; i--) {
			System.out.println("  ".repeat(i-1) + " _|");
		}
	}

	private void negativeNumber(int number) {
		int positiveNumber = Math.abs(number);
		System.out.println("_");
		for (int i = 0; i < positiveNumber; i++) {
			System.out.println("  ".repeat(i) + " |_");
		}

	}

	private void zeroNumber() {
		System.out.println("__");
	}

}
