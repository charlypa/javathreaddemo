package ai.core.boundedbuffer;

public class Session {
	private static final Buffer  buffer = new Buffer(100);
	private static final Thread producer1 = new Thread (new Producer (buffer,"p1",2000));
	private static final Thread producer2 = new Thread (new Producer (buffer,"p2",1000));
	private static final Thread consumer1 = new Thread (new Consumer (buffer,"c1",500));
	private static final Thread consumer2 = new Thread (new Consumer (buffer,"c2",2000));
	

	public static void start()
	{
		producer1.start();
		producer2.start();
		consumer1.start();
		consumer2.start();
		
	}
}
