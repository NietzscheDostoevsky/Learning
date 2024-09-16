package theMainThread;

public class CurrentThreadDemo {
	public static void main(String[] args) {
		Thread thread = Thread.currentThread();
		System.out.println("Current thread: " + thread);

		// cHAGE THE NAME OF THE THTREAD.
		thread.setName("mY tHREAD");
		System.out.println("After the name change: " + thread);
		try {
			for (int n = 5; n > 0; n--) {
				System.out.println(n);
				Thread.sleep(500);
			}
		} catch (InterruptedException e) {
			System.out.println("Main thread interrupted");
		}

	}
}
