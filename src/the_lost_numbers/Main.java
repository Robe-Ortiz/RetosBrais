package the_lost_numbers;

import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		 TheLostNumbers example = new TheLostNumbers();
		 List<Integer> lostNumberList = new ArrayList<>();
		 
		 try {
			lostNumberList = example.searchTheLostNumbers(-2,2,5,1,6,10);
		} catch (IncorrectArrayException e) {
			System.out.println(e.getMessage());
		}
		 
		 lostNumberList.forEach(System.out::println);		
	}
}
