/**
	采用面向对象的思维解决数三退一问题
	双向回环链表
*/

public class Count3Quit2
{
	public static void main(String args[])
	{
		KidCircle kc = new KidCircle(500);
		
		Kid k = kc.first;
		
		int count = 0;
		while(kc.size > 1)
		{
			count++;
			if(count == 3)
			{
				kc.delete(k);
				count = 0;
			}
			k = k.right;
		}
		System.out.println(kc.first.id);
	}
}

class Kid
{
	int id;
	//左手，右手
	Kid left;
	Kid right;
}

class KidCircle
{
	//圈有多大？
	int size = 0;
	//圈头和圈尾
	Kid last;
	Kid first;
	int location;
	
	//先考虑构造方法，再考虑其他方法
	KidCircle(int n)
	{
		for(int i = 0; i < n; i++)
		{
			add();
		}
	}
	
	void add()
	{
		Kid k = new Kid();
		k.id = size;
		if(size <= 0)
		{
			last = k;
			first = k;
			k.left = k;
			k.right = k;
			last = first;
		}
		//默认添加到最后一个人
		else
		{
			last.right = k;
			k.left = last;
			k.right = first;
			first.left = k;
			last = k;
		}
		size++;
	}
	
	void delete(Kid k)
	{
		if(size <= 0)	return;
		else if(size == 1)
		{
			first = last = null;
		}
		else
		{
			//k左手边那人的右手拉着k右手那人
			k.left.right = k.right;
			k.right.left = k.left;
			if(k == first)
			{
				first = k.right;
			}
			else if(k == last)
			{
				last = k.left;
			}
		}
		size--;
	}
}