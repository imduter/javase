//线程同步----线程对资源的访问问题
//当两个方法访问同一资源时，需要加同步，否则发生冲突。

public class TT implements Runnable
{
	int b = 100;
	
	//拿到当前对象的那把锁。
	public synchronized void f1() throws Exception
	{
		b = 1000;
		//休息，让主线线程得以执行
		Thread.sleep(5000);
		System.out.println("b = " + b);
	}

	//不需要得到当前对象的锁，也能执行。
		public void f2() throws Exception
		{
			Thread.sleep(2500);
			b = 2000;

		// 加锁后，资源只能等待f1()访问后，才能访问。
	// public synchronized void f2() throws Exception
	// {
		// Thread.sleep(2500);
		// b = 2000;
	}
	
	public void run()
	{
		try
		{
			f1();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public static void main(String args[]) throws Exception
	{
		TT tt = new TT();
		Thread t = new Thread(tt);
		
		t.start();
		//run()方法里f1()被调用。
		//未加锁的f2()，可以对资源b进行访问。
		tt.f2();
		System.out.println(tt.b);
	}
	
}
