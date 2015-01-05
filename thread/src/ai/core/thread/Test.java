package ai.core.thread;

public class Test {
	public static void test()
	{
		testInterface();
		testClass();
		testIncDec();
		
	}
	private static void testInterface()
	{
		System.out.println("Testing Interface");
		Thread t1 = new Thread(new TestInterface ());
		System.out.println("Thread t1 is"+t1);
		t1.run();
		
		try {
			t1.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private static void testClass()
	{
		System.out.println("Testing Class");
		Thread t1 = new ThreadExtend();
		t1.run();
		try {
			t1.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private static void testIncDec()
	{
		System.out.println("Testing Inc and Dec");
		Counter counter = new Counter();
		Thread t1 = new Thread(new Increment(counter));
		Thread t2 = new Thread(new Decrement(counter));
		
		t1.start();
		t2.start();
		
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("counter value is "+ counter.count());
		
		
	}
}
