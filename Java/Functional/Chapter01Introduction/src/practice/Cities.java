package practice;

import java.util.Arrays;
import java.util.List;

public class Cities {
	public static void main(String[] args) {
		
		//Finding a string in list of cities. 
		List<String> cities = Arrays.asList("Albany", "Boulder", "Chicago", "Denver", "Eugene");
		
		// Inperetive style 
		
		boolean found = false;
		for (String city: cities) {
			if (city.equals("Chicago")) {
				found = true;
				break;
			}
		}
		System.out.println("Found: " + found);
		
		// Declarative style 
		
		System.out.println("Found: " + cities.contains("Chicago"));
	}
}
