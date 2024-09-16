package chatGPTExamples;

class CPUIntensiveTask implements Runnable {
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + " is running: " + i);
            if (i % 3 == 0) {
                // Yield to allow other threads of the same priority to run
                System.out.println(Thread.currentThread().getName() + " yielding control...");
                Thread.yield();
            }
        }
    }
}

public class YieldExample {
    public static void main(String[] args) {
        // Create two threads with equal priority
        Thread t1 = new Thread(new CPUIntensiveTask(), "Thread 1");
        Thread t2 = new Thread(new CPUIntensiveTask(), "Thread 2");

        t1.setPriority(Thread.NORM_PRIORITY);
        t2.setPriority(Thread.NORM_PRIORITY);

        t1.start();
        t2.start();
    }
}
