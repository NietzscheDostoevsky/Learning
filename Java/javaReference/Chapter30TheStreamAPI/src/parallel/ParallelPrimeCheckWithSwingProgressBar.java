package parallel;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class ParallelPrimeCheckWithSwingProgressBar {

    private static JProgressBar progressBar;
    private static JFrame frame;

    public static void main(String[] args) {
        // Create and show the GUI
        SwingUtilities.invokeLater(() -> {
            createAndShowGUI();
            performComputation();
        });
    }

    private static void createAndShowGUI() {
        // Create and set up the window
        frame = new JFrame("Progress Bar Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 100);

        // Create and set up the progress bar
        progressBar = new JProgressBar(0, 100);
        progressBar.setStringPainted(true);

        // Add the progress bar to the content pane
        frame.getContentPane().add(progressBar, BorderLayout.CENTER);

        // Display the window
        frame.setVisible(true);
    }

    private static void performComputation() {
        // Create a large dataset of integers
        int size = 10_000_00;  // You can increase this further to intensify
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            numbers.add(i);
        }

        // Create an ExecutorService for parallel processing
        ExecutorService executorService = Executors.newFixedThreadPool(2); // Adjust thread pool size as needed

        // Start the computation and track progress
        Future<Long> future = executorService.submit(() -> {
            long count = numbers.parallelStream()
                .peek(n -> updateProgressBar(n + 1, size))  // Update progress bar
                .filter(ParallelPrimeCheckWithSwingProgressBar::intensivePrimeCheck)
                .count();
            return count;
        });

        // Wait for computation to finish
        try {
            long count = future.get(10, TimeUnit.MINUTES);  // Adjust timeout as needed
            JOptionPane.showMessageDialog(frame, "Parallel Prime Count: " + count);
        } catch (TimeoutException e) {
            System.out.println("Computation timed out.");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            executorService.shutdown();
            try {
                if (!executorService.awaitTermination(60, TimeUnit.SECONDS)) {
                    executorService.shutdownNow();
                }
            } catch (InterruptedException e) {
                executorService.shutdownNow();
            }
        }
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

    // Method to update the progress bar
    private static void updateProgressBar(int current, int total) {
        SwingUtilities.invokeLater(() -> {
            int progress = (int) ((double) current / total * 100);
            progressBar.setValue(progress);
        });
    }
}
