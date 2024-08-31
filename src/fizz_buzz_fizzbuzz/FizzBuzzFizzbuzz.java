package fizz_buzz_fizzbuzz;

public class FizzBuzzFizzbuzz {

	public static void fizz_Buzz_FizzBuzz() {
		for(int i = 1; i <= 100; i++) {
			if(i % 3 == 0 && i % 5 == 0) {
				System.out.println("FizzBuzz");
			}else if(i % 5 == 0) {
				System.out.println("Buzz");
			}else if(i % 3 == 0) {
				System.out.println("Fizz");
			}else {
				System.out.println(i);
			}
		}
	}
}
