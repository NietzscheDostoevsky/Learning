package parallel;

import java.util.ArrayList;
import java.util.List;

public class ParallelPrimeCheckWithProgressBar {
    public static void main(String[] args) {
        // Create a large dataset of integers
        int size = 10_000_0;  // You can increase this further to intensify
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            numbers.add(i);
        }

        // Measure the time for sequential processing with progress bar
        long startSequential = System.nanoTime();
        long countSequential = 0;
        int totalNumbers = numbers.size();
        for (int i = 0; i < totalNumbers; i++) {
            if (intensivePrimeCheck(numbers.get(i))) {
                countSequential++;
            }
            printProgressBar(i + 1, totalNumbers);
        }
        long endSequential = System.nanoTime();
        System.out.println("\nSequential Prime Count: " + countSequential);
        System.out.println("Sequential Time: " + (endSequential - startSequential) / 1_000_000 + " ms");

        // Measure the time for parallel processing with progress bar
        long startParallel = System.nanoTime();
        long countParallel = numbers.parallelStream()
                                    .peek(n -> printProgressBar(n + 1, size))  // Update progress bar
                                    .filter(ParallelPrimeCheckWithProgressBar::intensivePrimeCheck)
                                    .count();
        long endParallel = System.nanoTime();
        System.out.println("\nParallel Prime Count: " + countParallel);
        System.out.println("Parallel Time: " + (endParallel - startParallel) / 1_000_000 + " ms");
    }

    // A more intensive prime-checking function
    private static boolean intensivePrimeCheck(int number) {
        if (number < 2) return false;

        // Simulate additional heavy computation
        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                return false;
            }
        }

        // Additional heavy operations: Compute factorial of a small number (e.g., 10) and square roots
        long factorialResult = factorial(10);
        double sqrtResult = Math.sqrt(factorialResult * number);  // Just a dummy operation

        return true;
    }

    // A method to compute the factorial of a number
    private static long factorial(int n) {
        long result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    // Method to print a progress bar
    private static void printProgressBar(int current, int total) {
        final int barLength = 50;  // Length of the progress bar
        int progress = (int) ((double) current / total * barLength);
        StringBuilder progressBar = new StringBuilder("[");
        for (int i = 0; i < barLength; i++) {
            if (i < progress) {
                progressBar.append("=");
            } else {
                progressBar.append(" ");
            }
        }
        progressBar.append("] ").append((current * 100) / total).append("%");
        
        // Print the progress bar with carriage return to overwrite the previous line
        System.out.print("\r" + progressBar.toString());
        
        // Flush the output to ensure the progress bar updates immediately
        System.out.flush();
    }
}
