package chatGPTExamples;

class Counter {
    private int count = 0;

    public void increment() {
        count++;
    }

    public int getCount() {
        return count;
    }
}

class CounterSyncd {
	private int count = 0; 
	
	public synchronized void increment() {
		count++;
	}
	
	public int getCount() {
		return count;
	}
}
public class AsyncExample {
    public static void main(String[] args) {
        Counter counter = new Counter();
        CounterSyncd counterSyncd = new CounterSyncd();
        
        Thread t1 = new Thread(() -> {
        	for (int i = 0; i < 1000; i++)
        		counter.increment();
        		
        },"thread 1");
        
        Thread t2 = new Thread(() -> {
        	for (int i = 0; i < 1000; i++)
        		counter.increment();	
        },"thread 1");
        
        t1.start(); t2.start();
        
        try {
			t1.join();
			t2.join();
		} catch (Exception e) {
			e.printStackTrace();
		}
        
        Thread t3 = new Thread(() -> {
        	for (int i = 0; i < 1000; i++)
        		counterSyncd.increment();
        		
        },"thread 3");
        
        Thread t4 = new Thread(() -> {
        	for (int i = 0; i < 1000; i++)
        		counterSyncd.increment();	
        },"thread 4");
        
        t3.start(); t4.start();
        
        try {
			t3.join();
			t4.join();
		} catch (Exception e) {
			e.printStackTrace();
		}
        
        
        System.out.println("Final Asynchronized Count: " + counter.getCount());
        System.out.println("Final Synchronized Count: " + counterSyncd.getCount());
       
    }
}
