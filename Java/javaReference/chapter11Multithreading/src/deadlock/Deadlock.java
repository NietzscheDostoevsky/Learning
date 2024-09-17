package deadlock;

/*
 *  The next example creates two classes, A and B, 
 *  with methods foo() and bar(), respectively, which pause briefly 
 *  before trying to call a method in the other class. 
 *  The main class, named Deadlock, creates an A and a B instance, 
 *  and then calls deadlockStart() to start a second thread that sets up the deadlock condition.
 *  The foo() and bar() methods use sleep() as a way to force the deadlock condition to occur.
 */
class A {
	synchronized void foo(B b) {
		String name = Thread.currentThread().getName();
		System.out.println(name + " entered A.foo");

		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			System.out.println("A interrupted");
		}

		System.out.println(name + " trying to call B.last()");
		b.last();
	}

	synchronized void last() {
		System.out.println("Inside A.last");
	}
}

class B {
	synchronized void bar(A a) {
		String name = Thread.currentThread().getName();
		System.out.println(name + " entered B.bar");
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			System.out.println("B Interrupted");
		}
		
		System.out.println(name + " trying to call A.last()");
		a.last();
	}

	synchronized void last() {
		System.out.println("Inside B.last");
	}
}
public class Deadlock implements Runnable{
	A a = new A();
	B b = new B();
	Thread t; 
	
	public Deadlock() {
		Thread.currentThread().setName("MainThread");
		t = new Thread(this, "RacingThread");
	}
	
	void deadlockStart() {
		t.start();
		a.foo(b); // get lock on a in this thread. 
		System.out.println("Back in main thread");
	}
	
	public void run() {
		b.bar(a); // get lock on b in other thread. 
		System.out.println("Back in other thread");
	}
	
	public static void main(String[] args) {
		Deadlock dl = new Deadlock();
		dl.deadlockStart();
	}
}

/*
 * The moment you start multiple threads (MainThread and RacingThread), 
 * the order in which they acquire locks on objects A and B can differ. 
 * Sometimes, MainThread might run first and lock A, while other times, 
 * RacingThread might run first and lock B.
 * Regardless of which thread executes first, the deadlock will occur in both cases. 
 * The only difference is which thread prints its log messages first, 
 * depending on the order in which the JVM schedules them.


 */

