//TestSync.java---------�߳�ͬ��

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
		//�����̣߳�������ͬһ��timer����
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
		//���Ļ���---ִ�дη���������������ǰ����
		//synchronizid(this);
		num++;
		try
		{
			//�Ŵ�Ч������
			Thread.sleep(1);
		}
		catch(InterruptedException e)
		{
			e.printStackTrace();
		}
		System.out.println(s + "���ǵ�" + num + "ʹ��timer�̵߳ġ�");
	}
}