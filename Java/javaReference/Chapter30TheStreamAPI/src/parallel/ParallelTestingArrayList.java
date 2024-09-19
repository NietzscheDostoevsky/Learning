package parallel;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ParallelTestingArrayList {
    public static void main(String[] args) {
        
        // Create a large array.
        Stopwatch timer = new Stopwatch();
        
        int size = 10_000_000_0;
        List<Integer> list1 = new ArrayList<>();  // Change to ArrayList for better performance
        
        for (int i = 0; i < size; i++)
            list1.add(i);
        System.out.println(list1.size());
        System.out.println("List1 : " + timer.elapsedTime());
        
        timer = new Stopwatch();
        List<Integer> list2 = new ArrayList<>();
        for (int i : list1) {
            list2.add(i * 2 + 1);
        }
        System.out.println("List2 : " + timer.elapsedTime());
        
        timer = new Stopwatch();
        List<Integer> list3 = list1.stream()
                                   .map(a -> a * 2 + 1)
                                   .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);  // ArrayList instead of LinkedList
        System.out.println("List3 : " + timer.elapsedTime());
        
        timer = new Stopwatch();
        List<Integer> list4 = list1.parallelStream()
                                   .map(a -> a * 2 + 1)
                                   .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);  // Use ArrayList for parallel stream
        System.out.println("List4 : " + timer.elapsedTime());
        
    }
}

