package ai.core.thread;

public class Increment implements Runnable {
	private Counter counter;
	

	public Increment(Counter counter) {
		
		this.counter = counter;
		
	}

	@Override
	public void run() {
		
		int count = Counter.MAX;
		while (count-- > 0)
		{
			counter.inc();
		}
	}

}
