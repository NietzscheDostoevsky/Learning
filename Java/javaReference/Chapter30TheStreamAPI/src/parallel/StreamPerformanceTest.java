package parallel;

import java.util.ArrayList;
import java.util.List;

public class StreamPerformanceTest {
    public static void main(String[] args) {
        // Create a large dataset
    	System.out.println(Runtime.getRuntime().availableProcessors());
    	//System.setProperty("java.util.concurrent.ForkJoinPool.common.parallelism", "24");  // Set to 4 threads


        int size = 10_000_000;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            list.add(i);
        }

        // Warm up the JVM by running both tests multiple times
        for (int i = 0; i < 5; i++) {
            runSequential(list);
            runParallel(list);
        }

        // Test sequential stream performance
        long startSequential = System.nanoTime();
        runSequential(list);
        long endSequential = System.nanoTime();
        System.out.println("Sequential Time: " + (endSequential - startSequential) / 1_000_000 + " ms");

        // Test parallel stream performance
        long startParallel = System.nanoTime();
        runParallel(list);
        long endParallel = System.nanoTime();
        System.out.println("Parallel Time: " + (endParallel - startParallel) / 1_000_000 + " ms");
    }

    // Sequential Stream Operation
    private static void runSequential(List<Integer> list) {
        list.stream()
            .map(a -> a * 2 + 1)
            .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
    }

    // Parallel Stream Operation
    private static void runParallel(List<Integer> list) {
        list.parallelStream()
            .map(a -> a * 2 + 1)
            .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
    }
}
