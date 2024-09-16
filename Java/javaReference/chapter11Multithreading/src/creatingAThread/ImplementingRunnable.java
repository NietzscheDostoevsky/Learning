package creatingAThread;

// Creating a second thread. 
class NewThread implements Runnable {
	Thread thread; 
	
	public NewThread() {
		// Create a new, second thread. 
		thread = new Thread(this, "Demo Thread");
		System.out.println("Child thread: " + thread);
	}
	
	// This is the entry point for the second thread. 
	public void run() {
		try {
			for (int i = 10; i > 0; i--) {
				System.out.println("Child Thread: " + i);
				Thread.sleep(500);
			}
		} catch (Exception e) {
			System.out.println("Child interrupted");
		}
		System.out.println("Exiting child thread.");
	}
}

public class ImplementingRunnable {
	public static void main(String[] args) {
		NewThread nThread = new NewThread(); // creating a new thread. 
		nThread.thread.start(); // starting the thread. 
		
		try {
			for (int i = 10; i > 0; i--) {
				System.out.println("                    Main Thread: " + i);
				Thread.sleep(1000);
			}
		} catch (Exception e) {
			System.out.println("Main thread inturrupted");
		}
		System.out.println("                    Main thread exiting");
	}
}
