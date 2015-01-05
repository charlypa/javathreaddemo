package ai.core.boundedbuffer;

import java.util.Random;

public class Producer implements Runnable {
	private final Buffer buffer;
	private final Random random = new Random();
	private final String name;
	private final int waitTime;



	public Producer(Buffer buffer, String name, int waitTime) {
		super();
		this.buffer = buffer;
		this.name = name;
		this.waitTime = waitTime;
	}



	@Override
	public void run() {
		
		while (true)
		{
			int nextWait = random.nextInt(waitTime);
			try {
				Thread.sleep(nextWait);
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			buffer.put(nextWait);
			System.out.println("Produced Item "+name+ " "+ nextWait);
		}
	}

}
