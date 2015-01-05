package ai.core.boundedbuffer;

import java.util.Random;

public class Consumer implements Runnable {
	private final Buffer buffer;
	private final String name;
	private final int waitTime;
	private final Random random = new Random();
	



	public Consumer(Buffer buffer, String name, int waitTime) {
		super();
		this.buffer = buffer;
		this.name = name;
		this.waitTime = waitTime;
	}




	@Override
	public void run() {
		while (true)
		{
			int nexwait = random.nextInt(waitTime);
			try {
				Thread.sleep(nexwait);
				System.out.println("consumed by "+name+ " "+buffer.get());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
