package deadlock;

class Resource {
	private final String name;

	Resource(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}

class DeadlockDemo {
	private static final Resource resource1 = new Resource("Resource 1");
	private static final Resource resource2 = new Resource("Resource 2");

	public static void main(String[] args) {
		Thread t1 = new Thread(() -> {
			synchronized (resource1) {
				System.out.println("Thread 1: Locked resource 1");

				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
				}

				synchronized (resource2) {
					System.out.println("Thread 1: Locked resource 2");
				}
			}
		}, "Thread 1");

		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				synchronized (resource2) {
					System.out.println("Thread 2: Locked resource 2");

					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
					}

					synchronized (resource1) {
						System.out.println("Thread 1: Locked resource 1");
					}
				}
			}
		}, "Thread 2");

		t1.start();
		t2.start();
	}
}
