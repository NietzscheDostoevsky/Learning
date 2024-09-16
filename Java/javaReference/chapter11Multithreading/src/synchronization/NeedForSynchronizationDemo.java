package synchronization;

//This programme is NOT synchronized. 
class Callme {
	//void call(String msg)/ {
	synchronized void call(String msg) { // this makes it synchronized, only one thread can operate on it at a time.  
		System.out.print("[" + msg);
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			System.out.println("Interrupted");
		}
		System.out.println("]");
	}
}

class Caller implements Runnable {
	String msg;
	Callme target;
	Thread t;
	
	public Caller(Callme targ, String s) {
		target = targ;
		msg = s;
		t = new Thread(this);
	}
	
	public void run() {
		target.call(msg);
	}
}

public class NeedForSynchronizationDemo {
	public static void main(String[] args) throws InterruptedException {
		Callme target = new Callme();
		Caller ob1 = new Caller(target, "Hello");
		Caller ob2 = new Caller(target, "Synchronized");
		Caller ob3 = new Caller(target, "World");
		
		ob1.t.start();
		ob2.t.start();
		ob3.t.start();
		
		ob1.t.join();
		ob2.t.join();
		ob3.t.join();
	}
}
