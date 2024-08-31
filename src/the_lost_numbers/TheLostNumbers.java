package the_lost_numbers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TheLostNumbers {

	// check if the array has any duplicate numbers
	private boolean checkDuplicateNumber(Integer... numbersArrays) {
		Set<Integer> setNumbers = new HashSet<>(Arrays.asList(numbersArrays));
		if (numbersArrays.length != setNumbers.size())
			return true;
		return false;
	}

	// checks if the array is in order
	private boolean checkTheArrayOrder(Integer... numbersArrays) {
		List<Integer> numbersSorted = new ArrayList<Integer>(Arrays.asList(numbersArrays));
		Collections.sort(numbersSorted);
		for (int i = 0; i < numbersArrays.length; i++) {
			if (numbersArrays[i] != numbersSorted.get(i))
				return true;
		}
		return false;
	}

	// return a list with the lost numbers
	private List<Integer> checkForMissingNumbers(Integer... numbersArrays) {
		int currentNumber = numbersArrays[0];
		List<Integer> lostNumbers = new ArrayList<>();
		for (int i = 1; i < numbersArrays.length; i++) {
			while (numbersArrays[i] != currentNumber + 1)
				lostNumbers.add(++currentNumber);
			currentNumber = numbersArrays[i];
		}
		return lostNumbers;

	}

	// method that returns a list of the missing numbers in the array, otherwise returns an empty list
	public List<Integer> searchTheLostNumbers(Integer... numbersArrays) throws IncorrectArrayException {
		List<Integer> lostNumbers = new ArrayList<>();
		if (checkDuplicateNumber(numbersArrays)) {
			throw new IncorrectArrayException("Array con números duplicados.");
		} else if (checkTheArrayOrder(numbersArrays)) {
			throw new IncorrectArrayException("El array no está ordenado.");
		} else {
			lostNumbers = checkForMissingNumbers(numbersArrays);
		}
		return lostNumbers;
	}
}
