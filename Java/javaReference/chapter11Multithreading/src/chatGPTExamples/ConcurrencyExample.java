package chatGPTExamples;

class MyTask implements Runnable {
	public void run() {
		System.out.println("Task is running by " + Thread.currentThread().getName());
	}
}

public class ConcurrencyExample {
	public static void main(String[] args) {
		Thread thread1 = new Thread(new MyTask());
		Thread thread2 = new Thread(new MyTask());
		
		thread1.start();
		thread2.start();
	}
}
