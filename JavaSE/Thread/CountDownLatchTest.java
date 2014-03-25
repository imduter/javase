import java.util.concurrent.CountDownLatch;

/**
	CountDownLatch是一个同步辅助类，在完成一组其他线程执行的操作之前，
	它允许一个线程或则多个线程一直等待。
*/

public class CountDownLatchTest
{
	//模拟百米赛跑，10名运动员
	public static void main(String args[]) throws InterruptedException
	{
		//开始的倒数锁
		final CountDownLatch begin = new CountDownLatch(1);
		//结束的倒数锁
		final ExecutorService exec = Executors.newFixedThreadPool(10);
		for(int i = 0; i < 10; i++)
		{
			final int NO = i+1;
			
			Runnable run = new Runnable(){
				public void run()
				{
					try
					{
						//若计数为0，此方法立即返回
						begin.await();
						Thread.sleep((long) Math.random() * 10000);
						System.out.println("No." + NO + " arrived");  
					}
					catch(InterruptedException e)
					{
						e.printStackTrace();
					}
					finally
					{
						end.countDown();
					}
				}
			};
			exec.submit(run);
		}
		System.out.println("--------Start------");
		begin.countDown();
		end.await();
		System.out.println("--------End------");
		exec.shutdown();
	}
}