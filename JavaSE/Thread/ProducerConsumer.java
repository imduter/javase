//ProducerConsumer.java---生产者与消费者问题

/*
	面向对象思维，一上来不应该考虑细节
	而是想一想有哪些个类，哪些个属性

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

//馒头
class WoTou
{
	int id;
	
	WoTou(int id)
	{
		this.id = id;
	}
}

//装馒头的东西---用栈模拟(先进后出)
class SyncStack
{
	//器皿容量
	WoTou woTous[] = new WoTou[6];
	//栈顶指针
	int index = 0;
	
	//装入--避免多个生产者push()，发生冲突，加锁
	synchronized void push(WoTou woTou)
	{
		//避免超出器皿容量
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
	
	//拿出--避免多个消费者pop()时，发生冲突，加锁
	synchronized WoTou pop()
	{
		//当index--放在此处时，124行会报空指针错
		//原因：index已指零了，必须先判断。
		while/*if*---危险，catch后跳出执行，不再wait()*/(index == 0)
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
		//叫醒其他线程
		// this.notify();
		this.notifyAll();
		index--;
		return woTous[index];
	}
}

//生产者--每个生产者是一个线程，访问器皿。
class Producer implements Runnable
{
	//生产到那个器皿，总得知道
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
			System.out.println("生产了：woTou" + "(" + woTou.id + ")");
		}
	}
}

//消费者--每个消费者是一个线程，访问器皿。
class Consumer implements Runnable
{
	//到哪个器皿拿馒头，总得知道
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
			System.out.println("消费了：woTou" + "(" + woTou.id +")");
		}
	}
}