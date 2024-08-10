package recursion;

public class Recursion {

	public static void countdown(int num) {
		if(num >= 0) {
			System.out.println("Número " + num);
			countdown(--num);
		}
	}
	
	public static void factorial (int num) {
		int factorial = 1;
		for(int i = 2; i <= num;i++) {
			factorial *= i;
		}
		System.out.printf("El factorial de %d es %d \n",num,factorial);
	}
	
	/*Method easy but very slow*/
	public static long fibonacci (int num) {
		long result = num <= 1 ? num : fibonacci(num-1) + fibonacci(num -2);
		return result;
	}
	
	public static long fibonacciEnhanced(int num) {
		long operatorA = 1;
		long operatorB = 1;
		for(int i = 3; i <= num;i++) {
			long operatorC = operatorA + operatorB;
			operatorA = operatorB;
			operatorB = operatorC;
		}
		System.out.println("La solución es " + operatorB);
		return operatorB;
	}
	
	
	
	
	public static void main(String[] args) {
		Recursion.countdown(100);
		Recursion.factorial(4);
		//System.out.println(Recursion.fibonacci(77));
		Recursion.fibonacciEnhanced(77);
	}	
}
