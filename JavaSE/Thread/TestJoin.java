//TestJoin.java
//合并某个线程

public class TestJoin
{
	public static void main(String args[])
	{
		MyThread mt = new MyThread("mt");
		mt.start();
		try
		{
			mt.join();
		}
		catch(InterruptedException e)
		{
			e.printStackTrace();
		}
		System.out.println("I'm main thread.");
	}
}

class MyThread extends Thread
{
	MyThread(String s)
	{
		super(s);
	}
	
	public void run()
	{
		for(int i = 0; i < 10; i++)
		{
			System.out.println("I'm mt");
			try
			{
				sleep(1000);
			}
			catch(InterruptedException e)
			{
				e.printStackTrace();
			}
		}
	}
}