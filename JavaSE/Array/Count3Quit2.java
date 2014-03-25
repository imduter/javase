/**
	������������˼ά���������һ����
	˫��ػ�����
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
	//���֣�����
	Kid left;
	Kid right;
}

class KidCircle
{
	//Ȧ�ж��
	int size = 0;
	//Ȧͷ��Ȧβ
	Kid last;
	Kid first;
	int location;
	
	//�ȿ��ǹ��췽�����ٿ�����������
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
		//Ĭ����ӵ����һ����
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
			//k���ֱ����˵���������k��������
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