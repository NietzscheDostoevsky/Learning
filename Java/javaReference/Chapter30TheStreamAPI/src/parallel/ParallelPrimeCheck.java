package parallel;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class ParallelPrimeCheck {
    public static void main(String[] args) {
        // Create a large dataset of integers
        int size = 20_000_000;
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            numbers.add(i);
        }

        // Measure the time for sequential processing
        long startSequential = System.nanoTime();
        long countSequential = numbers.stream()
                                      .filter(ParallelPrimeCheck::isPrime)
                                      .count();
        long endSequential = System.nanoTime();
        System.out.println("Sequential Prime Count: " + countSequential);
        System.out.println("Sequential Time: " + (endSequential - startSequential) / 1_000_000 + " ms");

        // Measure the time for parallel processing
        long startParallel = System.nanoTime();
        long countParallel = numbers.parallelStream()
                                    .filter(ParallelPrimeCheck::isPrime)
                                    .count();
        long endParallel = System.nanoTime();
        System.out.println("Parallel Prime Count: " + countParallel);
        System.out.println("Parallel Time: " + (endParallel - startParallel) / 1_000_000 + " ms");
    }

    // Method to check if a number is prime
    private static boolean isPrime(int number) {
        if (number < 2) return false;
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
