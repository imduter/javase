//无意义的问题，没明白。
public class TTT implements Runnable
{
	int b = 100;
	public synchronized void f1() throws Exception
	{
		b = 1000;
		Thread.sleep(5000);
		System.out.println("b = " + b);
	}
	
	public void f2() throws Exception
	{
		System.out.println(b);
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
		TTT ttt = new TTT();
		Thread t = new Thread(ttt);
		t.start();
		
		Thread.sleep(1000);
		ttt.f2();
	}
}