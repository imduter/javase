//TestInterrupt.java

import java.util.*;

public class TestInterrupt
{
	public static void main(String args[])
	{
		MyThread mt = new MyThread();
		mt.start();
		try
		{
			Thread.sleep(10000);
		
		}
		catch (InterruptedException e){}
		mt.interrupt();
	}
}

class MyThread extends Thread
{
	public void run()
	{
		while(true)
		{
			System.out.println("===="+new Date()+"===");
			try
			{
				sleep(1000);//�Ժ���Ϊ��λ
			}
			catch (InterruptedException e)
			{
				return;
			}
		}
	}
}