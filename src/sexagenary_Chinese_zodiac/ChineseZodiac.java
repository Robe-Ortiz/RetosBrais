package sexagenary_Chinese_zodiac;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ChineseZodiac {

	private static Scanner input = new Scanner(System.in);
	private static Map<Integer,Map<String,String>> chineseZodiacMap = createChineseZodiacMap();
	
	//create Map with Animal / Elements
	private static Map<String,String> createZodiacEntryMap(String zodiacAnimal, String zodiacElement){
		Map<String,String> zodiacEntryMap = new HashMap<>();
		zodiacEntryMap.put(zodiacAnimal, zodiacElement);
		return zodiacEntryMap;
	}
	
	//create Map with Year / Animal/Elements
	private static Map<Integer,Map<String,String>> createChineseZodiacMap(){
		Map<Integer,Map<String,String>> chineseZodiacMap = new HashMap<>();	
	    chineseZodiacMap.put(1924, createZodiacEntryMap("Rat", "Wood"));
	    chineseZodiacMap.put(1925, createZodiacEntryMap("Ox", "Wood"));
	    chineseZodiacMap.put(1926, createZodiacEntryMap("Tiger", "Fire"));
	    chineseZodiacMap.put(1927, createZodiacEntryMap("Rabbit", "Fire"));
	    chineseZodiacMap.put(1928, createZodiacEntryMap("Dragon", "Earth"));
	    chineseZodiacMap.put(1929, createZodiacEntryMap("Snake", "Earth"));
	    chineseZodiacMap.put(1930, createZodiacEntryMap("Horse", "Metal"));
	    chineseZodiacMap.put(1931, createZodiacEntryMap("Sheep", "Metal"));
	    chineseZodiacMap.put(1932, createZodiacEntryMap("Monkey", "Water"));
	    chineseZodiacMap.put(1933, createZodiacEntryMap("Rooster", "Water"));
	    chineseZodiacMap.put(1934, createZodiacEntryMap("Dog", "Wood"));
	    chineseZodiacMap.put(1935, createZodiacEntryMap("Pig", "Wood"));
	    chineseZodiacMap.put(1936, createZodiacEntryMap("Rat", "Fire"));
	    chineseZodiacMap.put(1937, createZodiacEntryMap("Ox", "Fire"));
	    chineseZodiacMap.put(1938, createZodiacEntryMap("Tiger", "Earth"));
	    chineseZodiacMap.put(1939, createZodiacEntryMap("Rabbit", "Earth"));
	    chineseZodiacMap.put(1940, createZodiacEntryMap("Dragon", "Metal"));
	    chineseZodiacMap.put(1941, createZodiacEntryMap("Snake", "Metal"));
	    chineseZodiacMap.put(1942, createZodiacEntryMap("Horse", "Water"));
	    chineseZodiacMap.put(1943, createZodiacEntryMap("Sheep", "Water"));
	    chineseZodiacMap.put(1944, createZodiacEntryMap("Monkey", "Wood"));
	    chineseZodiacMap.put(1945, createZodiacEntryMap("Rooster", "Wood"));
	    chineseZodiacMap.put(1946, createZodiacEntryMap("Dog", "Fire"));
	    chineseZodiacMap.put(1947, createZodiacEntryMap("Pig", "Fire"));
	    chineseZodiacMap.put(1948, createZodiacEntryMap("Rat", "Earth"));
	    chineseZodiacMap.put(1949, createZodiacEntryMap("Ox", "Earth"));
	    chineseZodiacMap.put(1950, createZodiacEntryMap("Tiger", "Metal"));
	    chineseZodiacMap.put(1951, createZodiacEntryMap("Rabbit", "Metal"));
	    chineseZodiacMap.put(1952, createZodiacEntryMap("Dragon", "Water"));
	    chineseZodiacMap.put(1953, createZodiacEntryMap("Snake", "Water"));
	    chineseZodiacMap.put(1954, createZodiacEntryMap("Horse", "Wood"));
	    chineseZodiacMap.put(1955, createZodiacEntryMap("Sheep", "Wood"));
	    chineseZodiacMap.put(1956, createZodiacEntryMap("Monkey", "Fire"));
	    chineseZodiacMap.put(1957, createZodiacEntryMap("Rooster", "Fire"));
	    chineseZodiacMap.put(1958, createZodiacEntryMap("Dog", "Earth"));
	    chineseZodiacMap.put(1959, createZodiacEntryMap("Pig", "Earth"));
	    chineseZodiacMap.put(1960, createZodiacEntryMap("Rat", "Metal"));
	    chineseZodiacMap.put(1961, createZodiacEntryMap("Ox", "Metal"));
	    chineseZodiacMap.put(1962, createZodiacEntryMap("Tiger", "Water"));
	    chineseZodiacMap.put(1963, createZodiacEntryMap("Rabbit", "Water"));
	    chineseZodiacMap.put(1964, createZodiacEntryMap("Dragon", "Wood"));
	    chineseZodiacMap.put(1965, createZodiacEntryMap("Snake", "Wood"));
	    chineseZodiacMap.put(1966, createZodiacEntryMap("Horse", "Fire"));
	    chineseZodiacMap.put(1967, createZodiacEntryMap("Sheep", "Fire"));
	    chineseZodiacMap.put(1968, createZodiacEntryMap("Monkey", "Earth"));
	    chineseZodiacMap.put(1969, createZodiacEntryMap("Rooster", "Earth"));
	    chineseZodiacMap.put(1970, createZodiacEntryMap("Dog", "Metal"));
	    chineseZodiacMap.put(1971, createZodiacEntryMap("Pig", "Metal"));
	    chineseZodiacMap.put(1972, createZodiacEntryMap("Rat", "Water"));
	    chineseZodiacMap.put(1973, createZodiacEntryMap("Ox", "Water"));
	    chineseZodiacMap.put(1974, createZodiacEntryMap("Tiger", "Wood"));
	    chineseZodiacMap.put(1975, createZodiacEntryMap("Rabbit", "Wood"));
	    chineseZodiacMap.put(1976, createZodiacEntryMap("Dragon", "Fire"));
	    chineseZodiacMap.put(1977, createZodiacEntryMap("Snake", "Fire"));
	    chineseZodiacMap.put(1978, createZodiacEntryMap("Horse", "Earth"));
	    chineseZodiacMap.put(1979, createZodiacEntryMap("Sheep", "Earth"));
	    chineseZodiacMap.put(1980, createZodiacEntryMap("Monkey", "Metal"));
	    chineseZodiacMap.put(1981, createZodiacEntryMap("Rooster", "Metal"));
	    chineseZodiacMap.put(1982, createZodiacEntryMap("Dog", "Water"));
	    chineseZodiacMap.put(1983, createZodiacEntryMap("Pig", "Water"));
	    
		return chineseZodiacMap;
	}

	//print zodiac sign according to the year
	private static void printChineseZodiacByYear(int year) {
		int zodiacYear = year;
		while(zodiacYear > 1983) {zodiacYear -= 60;}
		while(zodiacYear < 1924) {zodiacYear += 60;}	
	System.out.println(chineseZodiacMap.get(zodiacYear).toString());
	}
	
	// request one year per console to the user
	private static int requestAYear() {
		boolean correctYear = false;
		int year = 0;
		while(!correctYear) {
			try {
				System.out.print("Por favor, introduzca el año: ");
				String inputYear = input.nextLine().trim();
				year = Integer.parseInt(inputYear);
				correctYear = true;
			}catch (NumberFormatException e) {
				System.out.println("Lo siento, no ha introducido un año válido.");
			}
		}
		return year;
	}
	
	// request if application can finish
	private static boolean requestFinishApplication() {
		String answer = "";
		while(!(answer.equalsIgnoreCase("s") || answer.equalsIgnoreCase("n"))) {
			System.out.print("¿ Quieres buscar otro año ? (s/n): ");
			answer = input.nextLine().trim();
		}
		if( answer.equalsIgnoreCase("s")) {
			return false;
		}else {
			System.out.println("Program finish.");
			return true;
		}
	}
	
	// run application
	public static void application() {
		boolean finish = false;
		while(!finish) {
			printChineseZodiacByYear(requestAYear());
			finish = requestFinishApplication();
		}
	}
		
	
}
