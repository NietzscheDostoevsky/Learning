package interThreadCommunicationWrong;

/* 
 * Implementing a simple form of the producer/consumer problem. 
 * It consists of four classes: 
 * 		1. Q: the queue we are trying to synchronize
 * 		2. Producer: the threaded object that is producing queue entries.
 * 		3. Consumer: the threaded object that is consuming queue entries. 
 * 		4. PC: the driver class that creates the single Q, Producer, and Consumer. 
 */

// An incorrect implementation of a producer and consumer. 
class Q {
	int n;
	synchronized int get() {
		System.out.println("Got: " + n);
		return n;
	}
	
	synchronized void put (int n) {
		this.n = n;
		System.out.println("Put: " + n);
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
		while(true)
			q.put(i++);
	}
}

class Consumer implements Runnable {
	Q q;
	Thread t; 
	
	Consumer(Q q){
		this.q = q;
	}
	
	public void run() {
		while(true) 
			q.get();
	}
}

public class PC {
	public static void main(String[] args)  {
		Q q = new Q();
		Producer producer = new Producer(q);
		Consumer consumer = new Consumer(q);
		
		// Start the threads
		producer.t.start();
		consumer.t.start();
		
	}
}





































