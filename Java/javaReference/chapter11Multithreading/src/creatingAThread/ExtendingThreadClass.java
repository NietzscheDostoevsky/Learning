package creatingAThread;

class NewThread1 extends Thread {

	public NewThread1() {
		super("MyThread");
		System.out.println("Child thread: " + this);
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
		System.out.println("Exiting child\nthread.");
	}
}

public class ExtendingThreadClass {
	public static void main(String[] args) {
		NewThread1 nt =  new NewThread1();
		nt.start();
		
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
