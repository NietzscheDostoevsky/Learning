package synchronization;

class Callme2 {
	void call(String msg) {
		System.out.print("[" + msg);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			System.out.println("Interrupted");
		}
		System.out.println("]");
	}
}

class Caller2 implements Runnable {
	String msgString ;
	Callme2 targetCallme2;
	Thread t;
	
	public Caller2 (Callme2 target, String s) {
		targetCallme2 = target;
		msgString = s; 
		t = new Thread(this);
	}
	
	//Synchronize calls to call();
	public void run() {
		synchronized (targetCallme2) {
			targetCallme2.call(msgString);
		}	
	}
}

public class NeedForSynchronizationDemo2 {
	public static void main(String[] args) throws InterruptedException {
		Callme2 target = new Callme2();
		Caller2 ob1 = new Caller2(target, "Hello");
		Caller2 ob2 = new Caller2(target, "Synchronized");
		Caller2 ob3 = new Caller2(target, "World");

		ob1.t.start();
		ob2.t.start();
		ob3.t.start();

		ob1.t.join();
		ob2.t.join();
		ob3.t.join();
	}
}
