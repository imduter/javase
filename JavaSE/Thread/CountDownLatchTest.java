import java.util.concurrent.CountDownLatch;

/**
	CountDownLatch��һ��ͬ�������࣬�����һ�������߳�ִ�еĲ���֮ǰ��
	������һ���̻߳������߳�һֱ�ȴ���
*/

public class CountDownLatchTest
{
	//ģ��������ܣ�10���˶�Ա
	public static void main(String args[]) throws InterruptedException
	{
		//��ʼ�ĵ�����
		final CountDownLatch begin = new CountDownLatch(1);
		//�����ĵ�����
		final ExecutorService exec = Executors.newFixedThreadPool(10);
		for(int i = 0; i < 10; i++)
		{
			final int NO = i+1;
			
			Runnable run = new Runnable(){
				public void run()
				{
					try
					{
						//������Ϊ0���˷�����������
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