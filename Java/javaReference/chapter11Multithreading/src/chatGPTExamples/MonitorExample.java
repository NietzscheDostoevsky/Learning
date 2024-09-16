package chatGPTExamples;

class SharedResource {
	private int counter = 0; 
	
	// synchronized method: allows only one thread at a time to execute this method. 
	public synchronized void increment() {
		counter++;
		System.out.println(Thread.currentThread().getName() + " incremented counter to " + counter);
	}
}

public class MonitorExample {
	public static void main(String[] args) {
		SharedResource shared = new SharedResource();
		
		// Create multiple therads that share the same resource. 
		Thread t1 = new Thread(() -> {
			for (int i = 0; i < 5; i++)
				shared.increment();
		}, "Thrad 1");
		
		Thread t2 = new Thread(() -> {
			for (int i = 0; i < 5; i++)
				shared.increment();
		}, "Thrad 2");
		
		t1.start();
		t2.start();
	}
}
