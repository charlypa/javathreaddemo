package ai.core.boundedbuffer;

import java.util.concurrent.Semaphore;

public class Buffer {
	private final int [] buffer;
	private final int DEFAULT_SIZE = 10;
	private final Semaphore full;
	private final Semaphore empty;
	private final Object buffermutex = new Object();
	private final Object producerMutex = new Object();
	private final Object consumerMutex = new Object();
	private int in = 0;
	private int out = 0;
	
	public Buffer()
	{
		this.buffer = new int[DEFAULT_SIZE];
		this.full = new Semaphore(0,true);
		this.empty = new Semaphore(buffer.length, true);
		
	}
	public Buffer(int size)
	{
		this.buffer = new int[size];
		this.full = new Semaphore(0);
		this.empty = new Semaphore(buffer.length);
	}
	public void put(int item)
	{
		try {
		
			//synchronized (producerMutex) 
			{
				empty.acquire();
				synchronized(producerMutex)
				//synchronized (buffermutex) 
				{
					buffer[in] = item;
					in = (in + 1)%buffer.length;
					
				}
				full.release();
			}
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public int get()
	{
		int retval = -1;
		try {
			//synchronized (consumerMutex) 
			{
				full.acquire();
				synchronized(consumerMutex)
				//synchronized(buffermutex)
				{
					retval = buffer[out];
					out = (out + 1) % buffer.length;
				}
				empty.release();
			}
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return retval;
		
	}

}
