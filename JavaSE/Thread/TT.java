//�߳�ͬ��----�̶߳���Դ�ķ�������
//��������������ͬһ��Դʱ����Ҫ��ͬ������������ͻ��

public class TT implements Runnable
{
	int b = 100;
	
	//�õ���ǰ������ǰ�����
	public synchronized void f1() throws Exception
	{
		b = 1000;
		//��Ϣ���������̵߳���ִ��
		Thread.sleep(5000);
		System.out.println("b = " + b);
	}

	//����Ҫ�õ���ǰ���������Ҳ��ִ�С�
		public void f2() throws Exception
		{
			Thread.sleep(2500);
			b = 2000;

		// ��������Դֻ�ܵȴ�f1()���ʺ󣬲��ܷ��ʡ�
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
		//run()������f1()�����á�
		//δ������f2()�����Զ���Դb���з��ʡ�
		tt.f2();
		System.out.println(tt.b);
	}
	
}
