//ProducerConsumer.java---������������������

/*
	�������˼ά��һ������Ӧ�ÿ���ϸ��
	������һ������Щ���࣬��Щ������

*/

public class ProducerConsumer
{
	public static void main(String args[])
	{
		SyncStack ss = new SyncStack();
		Producer p = new Producer(ss);
		Consumer c = new Consumer(ss);
		
		new Thread(p).start();
		new Thread(c).start();
	}
}

//��ͷ
class WoTou
{
	int id;
	
	WoTou(int id)
	{
		this.id = id;
	}
}

//װ��ͷ�Ķ���---��ջģ��(�Ƚ����)
class SyncStack
{
	//��������
	WoTou woTous[] = new WoTou[6];
	//ջ��ָ��
	int index = 0;
	
	//װ��--������������push()��������ͻ������
	synchronized void push(WoTou woTou)
	{
		//���ⳬ����������
		while(index == woTous.length)
		{
			try
			{
			//Causes the current thread to wait until another thread invokes the notify() method 
			//or the notifyAll() method for this object
			//This method should only be called by a thread that is the owner of this object's monitor
				this.wait();
			}
			catch(InterruptedException e)
			{
				e.printStackTrace();
			}
		}
		//this.notify();
			
		woTous[index] = woTou;
		index++;
	}
	
	//�ó�--������������pop()ʱ��������ͻ������
	synchronized WoTou pop()
	{
		//��index--���ڴ˴�ʱ��124�лᱨ��ָ���
		//ԭ��index��ָ���ˣ��������жϡ�
		while/*if*---Σ�գ�catch������ִ�У�����wait()*/(index == 0)
		{
			try
			{
				this.wait();
			}
			catch(InterruptedException e)
			{
				e.printStackTrace();
			}
		}
		//���������߳�
		// this.notify();
		this.notifyAll();
		index--;
		return woTous[index];
	}
}

//������--ÿ����������һ���̣߳���������
class Producer implements Runnable
{
	//�������Ǹ������ܵ�֪��
	SyncStack ss;
	
	Producer(SyncStack ss)
	{
		this.ss = ss;
	}
	
	@Override
	public void run()
	{
		for(int i = 0; i < 20; i++)
		{
			WoTou woTou = new WoTou(i);
			ss.push(woTou);
			System.out.println("�����ˣ�woTou" + "(" + woTou.id + ")");
		}
	}
}

//������--ÿ����������һ���̣߳���������
class Consumer implements Runnable
{
	//���ĸ���������ͷ���ܵ�֪��
	SyncStack ss;
	
	Consumer(SyncStack ss)
	{
		this.ss = ss;
	}
	
	@Override
	public void run()
	{
		for(int i = 0; i < 20; i++)
		{
			WoTou woTou = ss.pop();
			System.out.println("�����ˣ�woTou" + "(" + woTou.id +")");
		}
	}
}