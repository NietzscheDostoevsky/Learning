package creatingAThread;

class MultiThread implements Runnable {
	String name;
	Thread thread;

	public MultiThread(String name) {
		this.name = name;
		this.thread = new Thread(this, this.name);
		System.out.println("New Thread: " + this.thread);
	}

	public void run() {
		try {
			for (int i = 5; i > 0; i--) {
				System.out.println(name + ": " + i);
				Thread.sleep(1000);
			}
		} catch (InterruptedException e) {
			System.out.println(name + "Interrupted");
		}
		System.out.println(name + " exiting.");

	}
}

public class MultiThreadDemo {
	public static void main(String[] args) throws InterruptedException {
		MultiThread m1 = new MultiThread("One   ");
		MultiThread m2 = new MultiThread("Two   ");
		MultiThread m3 = new MultiThread("Three ");

		m1.thread.start();
		m2.thread.start();
		Thread.sleep(5000);
		m3.thread.start();

		try {
			// wait for other threads to end
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			System.out.println("Main thread Interrupted");
		}
		System.out.println("Main thread exiting.");
	}
}
