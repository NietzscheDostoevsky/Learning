package montyHall;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/*
 * Demostrate the simulation of Monty Hall problem
 * Where the decision is to switch the door or not
 * chosen initially. 
 */

public class Monty {

	public static void out(String out) {
		System.out.print(out);
	}
	
	public static void play(boolean switchDoor) {
		// Hide the car behind one of the three doors chosen randomly 
		
		List<String> doorStrings =new  ArrayList<String>(Arrays.asList("car", "goat","goat")); 
		Collections.shuffle(doorStrings);
		
		// Let the player make their first guess and choose their door. 
		int[] doors = {1,2,3};
		int chosenDoor =  doors[new Random().nextInt(doors.length)];
		out("Player chooses door " + chosenDoor);
		
	}
	
}
