package ai.core.thread;

public class Counter {

	public static final int MAX = 50000;
	private volatile int count;
	public  synchronized void inc()
	{
		synchronized(this)
		{
			count++;
		}
		try {
			wait();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public  void dec()
	{
		synchronized (this) {
			count--;
		}
		
	}
	int count()
	{
		return count;
	}
}
