//死锁问题，哲学家吃饭问题

public class TestDeadLock implements Runnable
{
	private int flag;
	static Object o1 = new Object(), o2 = new Object();
	
	public void run()
	{
		System.out.println("flag =" + flag);
		if(flag == 1)
		{
			synchronized(o1)
			{
				try
				{
					Thread.sleep(500);
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				//flag == 0锁住了o2
				synchronized(o2)
				{
					System.out.println("1");
				}
			}

		}
		if(flag == 0)
		{
			synchronized(o2)
			{
				try
				{
					Thread.sleep(500);
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				//flag == 0锁住了o1
				synchronized(o1)
				{
					System.out.println("0");
				}
			}
		}
	}
	
	public static void main(String args[])
	{
		 TestDeadLock t1 = new TestDeadLock();
		 TestDeadLock t2 = new TestDeadLock();
		 t1.flag = 1;
		 t2.flag = 0;
		 new Thread(t1).start();
		 new Thread(t2).start();
	}
}