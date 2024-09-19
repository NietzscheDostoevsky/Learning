package parallel;

import java.util.ArrayList;
import java.util.List;

public class ParallelPrimeCheckIntensive {
    public static void main(String[] args) {
        // Create a large dataset of integers
        int size = 10_000_000;  // You can increase this further to intensify
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            numbers.add(i);
        }

        // Measure the time for sequential processing
        long startSequential = System.nanoTime();
        long countSequential = numbers.stream()
                                      .filter(ParallelPrimeCheckIntensive::intensivePrimeCheck)
                                      .count();
        long endSequential = System.nanoTime();
        System.out.println("Sequential Prime Count: " + countSequential);
        System.out.println("Sequential Time: " + (endSequential - startSequential) / 1_000_000 + " ms");

        // Measure the time for parallel processing
        long startParallel = System.nanoTime();
        long countParallel = numbers.parallelStream()
                                    .filter(ParallelPrimeCheckIntensive::intensivePrimeCheck)
                                    .count();
        long endParallel = System.nanoTime();
        System.out.println("Parallel Prime Count: " + countParallel);
        System.out.println("Parallel Time: " + (endParallel - startParallel) / 1_000_000 + " ms");
    }

    // A more intensive prime-checking function
    private static boolean intensivePrimeCheck(int number) {
        if (number < 2) return false;

        // Simulate additional heavy computation by checking divisibility up to the number itself
        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                return false;
            }
        }

        // Additional heavy operations: Compute factorial of a small number (e.g., 10) and square roots
        long factorialResult = factorial(10);
        double sqrtResult = Math.sqrt(factorialResult * number);  // Just a dummy operation

        // Return true if the number is prime
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
}
