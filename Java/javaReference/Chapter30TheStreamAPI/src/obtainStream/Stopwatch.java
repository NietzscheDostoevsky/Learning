package obtainStream;

public class Stopwatch {

	private final long start;

	public Stopwatch() {
		// constructor
		start = System.nanoTime();
	}

	public double elapsedTime() {
		long now = System.nanoTime();
		return (now - start) / 1.0e9;
	}

}
