package creatingAThread;

class NewThread3 implements Runnable {
	public void run() {
		String name = Thread.currentThread().getName();
		System.out.println("New thread: " + name);
		for (int i = 5; i > 0; i--) {
			System.out.println(name + " : " + i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				System.out.println(name + " interrupted.");
			}
		}
		System.out.println(name + " exiting");
	}
}

public class JoinDemo {
	public static void main(String[] args) {
		Thread t1 = new Thread(new NewThread3(), "Thread1");
		Thread t2 = new Thread(new NewThread3(), "Thread2");
		Thread t3 = new Thread(new NewThread3(), "Thread3");
		
		t1.start();
		t2.start();
		t3.start();
		
		System.out.println("Thread 1 is alive: " + t1.isAlive());
		System.out.println("Thread 2 is alive: " + t2.isAlive());
		System.out.println("Thread 3 is alive: " + t3.isAlive());
		
		try {
			System.out.println("Wating for threads to finish. ");
			t1.join(1000);
			t2.join(1000);
			t3.join(1000);
		} catch (Exception e) {
			System.out.println("Main thread inturrupted");
		}
		
		System.out.println("Thread 1 is alive: " + t1.isAlive());
		System.out.println("Thread 2 is alive: " + t2.isAlive());
		System.out.println("Thread 3 is alive: " + t3.isAlive());
		
		System.out.println("Main thread exiting");
	}
}
