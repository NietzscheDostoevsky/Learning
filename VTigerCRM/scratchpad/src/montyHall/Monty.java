import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Monty {

    public static void out(String out) {
        System.out.print(out);
    }

    public static boolean play(boolean switchDoor) {
        // Hide the car behind one of the three doors chosen randomly 
        List<String> doorStrings = new ArrayList<>(Arrays.asList("car", "goat", "goat"));
        Collections.shuffle(doorStrings); // Randomize the door positions

        // Let the player make their first guess and choose their door 
        int chosenDoor = new Random().nextInt(3); // Randomly choose between doors 0, 1, 2
        out("Player chooses door " + (chosenDoor + 1) + "; ");

        // The host now opens one of the unchosen doors that contains a goat
        List<Integer> remainingDoors = new ArrayList<>();
        for (int i = 0; i < doorStrings.size(); i++) {
            if (i != chosenDoor && doorStrings.get(i).equals("goat")) {
                remainingDoors.add(i);
            }
        }

        // Randomly select a door from the remaining ones that contains a goat
        int hostOpensDoor = remainingDoors.get(new Random().nextInt(remainingDoors.size()));
        out("Host shows door " + (hostOpensDoor + 1) + " has a goat; ");

        if (switchDoor) {
            // The player switches to the other remaining door
            for (int i = 0; i < doorStrings.size(); i++) {
                if (i != chosenDoor && i != hostOpensDoor) {
                    chosenDoor = i;
                    break;
                }
            }
            out("Player switches to door " + (chosenDoor + 1) + "; ");
        } else {
            // The player sticks with their original door
            out("Player sticks with door " + (chosenDoor + 1) + "; ");
        }

        // Reveal what's behind the chosen door
        out("Door " + (chosenDoor + 1) + " has " + doorStrings.get(chosenDoor) + "; ");
        boolean win = doorStrings.get(chosenDoor).equals("car");
        out("Player " + (win ? "wins!" : "loses!") + "\n");

        return win;
    }

    public static void main(String[] args) {
        int games = 1000; // Number of times to play the game

        // Simulation 1: Player never switches doors
        System.out.println("Simulation 1: No Switching");
        int wins = 0;
        for (int i = 0; i < games; i++) {
            if (play(false)) {
                wins++;
            }
        }
        double successRate1 = (double) wins / games;
        System.out.println();

        // Simulation 2: Player always switches doors
        System.out.println("Simulation 2: Always Switching");
        wins = 0;
        for (int i = 0; i < games; i++) {
            if (play(true)) {
                wins++;
            }
        }
        double successRate2 = (double) wins / games;
        System.out.println();

        // Print the success rates
        System.out.printf("Success rate without switching: %.2f%%\n", successRate1 * 100);
        System.out.printf("Success rate with switching: %.2f%%\n", successRate2 * 100);
    }
}
