package ai.core.thread;

public class Decrement implements Runnable {

	Counter counter;
	
	public Decrement(Counter counter) {
		
		this.counter = counter;
	}

	@Override
	public void run() {
		int count = Counter.MAX;
		while (count-- > 0)
		{
			counter.dec();
		}
	}

}
