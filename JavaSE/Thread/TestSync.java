//TestSync.java---------线程同步

public class TestSync implements Runnable
{
	Timer timer = new Timer();
	public static void main(String args[])
	{
		TestSync test = new TestSync();
		Thread t1 = new Thread(test);
		t1.setName("t1");

		Thread t2 = new Thread(test);
		t2.setName("t2");
		t1.start();
		t2.start();
		//两个线程，访问了同一个timer对象
	}
	public void run()
	{
		timer.add(Thread.currentThread().getName());
	}
}

class Timer
{
	static int num = 0;
	public void add(String s)
	{
		//锁的机制---执行次方法过程中锁定当前对象
		//synchronizid(this);
		num++;
		try
		{
			//放大效果而已
			Thread.sleep(1);
		}
		catch(InterruptedException e)
		{
			e.printStackTrace();
		}
		System.out.println(s + "你是第" + num + "使用timer线程的。");
	}
}