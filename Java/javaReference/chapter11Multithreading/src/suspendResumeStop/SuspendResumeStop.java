package suspendResumeStop;
// Suspending and Resuming a thread in modern way

/*
 * The NewThread class contains a boolean instance variable named suspendFlag, 
 * which is used to control the execution of the thread. 
 * It is initialized to false by the constructor. 
 * The run() method contains a synchronized statement block that checks suspendFlag. 
 * If that variable is true, the wait() method is invoked 
 * to suspend the execution of the thread. 
 * The mysuspend() method sets suspendFlag to true. 
 * The myresume ) method sets suspendFlag to false and 
 * invokes notify() to wake up the thread. 
 * Finally, the main() method has been modified to invoke 
 * the mysuspend() and myresume() methods.
 */

class NewThread implements Runnable {
	String name; 
	Thread t; 
	boolean suspendFlag; 
	
	NewThread(String threadname) {
		this.name = threadname;
		t = new Thread(this, name);
		System.out.println("New Thread: " + t);
		suspendFlag = false; 
	}
	
	public void run() {
		try {
			for (int i = 15; i > 0; i--) {
				System.out.println(name + ": " + i);
				Thread.sleep(200);
				synchronized (this) {
					while(suspendFlag)
						wait();
				}
			}
		} catch (InterruptedException e) {
			System.out.println(name + " Interrpted");
		}
		System.out.println(name + " exiting");
	}
	
	synchronized void mysuspend() {
		suspendFlag = true;
	}
	synchronized void myresume() {
		suspendFlag = false;
		notify();
	}
}

public class SuspendResumeStop {
	public static void main(String[] args) throws InterruptedException {
		NewThread ob1 = new NewThread("T1");
		NewThread ob2 = new NewThread("             T2");
		
		ob1.t.start();
		ob2.t.start();
		
		Thread.sleep(1000);
		ob1.mysuspend();
		System.out.println("Suspending thread T1");
		Thread.sleep(1000);
		ob1.myresume();
		System.out.println("Resuming thread T1");
		ob2.mysuspend();
		System.out.println("Suspending thread T2");
		Thread.sleep(1000);
		ob2.myresume();
		System.out.println("Resuming thread T2");
		
		ob1.t.join();
		ob2.t.join();
		System.out.println("Main thread exiting");
		
	}
}
