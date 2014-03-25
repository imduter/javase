//TestThread1.java

public class TestThread1
{
	public static void main(String args[])
	{
		Runner1 r = new Runner1();
		//r.run();//调用方法
		Thread t = new Thread(r);
		t.start();//起一个新的线程

		for(int i = 0; i < 100; i++)
			System.out.println("Main Thread:------------" + i);
	 }
}

class Runner1 implements Runnable
{
	public void run()
	{
		for(int i = 0; i < 100; i++)
			System.out.println("Runner1:" + i);
	}
}