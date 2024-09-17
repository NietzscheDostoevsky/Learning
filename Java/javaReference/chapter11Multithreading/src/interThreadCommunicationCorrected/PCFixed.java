package interThreadCommunicationCorrected;

/* 
 * Implementing a simple form of the producer/consumer problem. 
 * It consists of four classes: 
 * 		1. Q: the queue we are trying to synchronize
 * 		2. Producer: the threaded object that is producing queue entries.
 * 		3. Consumer: the threaded object that is consuming queue entries. 
 * 		4. PC: the driver class that creates the single Q, Producer, and Consumer. 
 */

// Corrected implementation of producer and consumer
class Q {
	int n;
	boolean valueSet = false;

	synchronized int get() {
		while (!valueSet)
			try {
				wait();
			} catch (InterruptedException e) {
				System.out.println("Interrupted caught");
			}
		System.out.println("Got: " + n);
		valueSet = false;
		notify();
		return n;
	}

	synchronized void put(int n) {
		while (valueSet) {
			try {
				wait();
			} catch (InterruptedException e) {
				System.out.println("Interrupted exceptino");
			}
		}

		this.n = n;
		valueSet = true;
		System.out.println("Put: " + n);
		notify();
	}
}

class Producer implements Runnable {
	Q q; 
	Thread t;
	Producer(Q q) {
		this.q = q;
		t = new Thread(this, "Producer");
	}
	
	public void run() {
		int i = 0; 
		while (true)
			q.put(i++);
	}
}

class Consumer implements Runnable {
	Q q; 
	Thread t;
	
	Consumer (Q q) {
		this.q = q;
		this.t = new Thread(this, "Consumer");
	}
	
	public void run() {
		while (true) 
			q.get();
	}
}

public class PCFixed {
	public static void main(String[] args) {
		Q q = new Q();
		Producer p = new Producer(q);
		Consumer c = new Consumer(q);
		// Start the threads.
		p.t.start();
		c.t.start();
		System.out.println("Press Control-C to stop.");
	}
}
