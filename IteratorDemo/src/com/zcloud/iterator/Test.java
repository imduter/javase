package com.zcloud.iterator;

import com.zcloud.iterator.*;

/**
 * 1.����ӿڱ��
 * 2.��������������ͬ��ͬһʵ�ֽӿڡ�
 * ����ʵ����ʵ�ֽӿڵ���ȥ����ʵ��
 * 3.���͵�ʵ��
 * 4.�ӿڸ���ԭ��
 * �������˴򽻵���ֻ��Ҫ�ҵ���صľ��У�����֪��������
 * 
 * */
public class Test 
{

	public static void main(String[] args) 
	{
		LinkedList ll = new LinkedList();
		
		for(int i = 0; i < 15; i++)
		{
			ll.add(new Cat(i));
		}
		
		Iterator it = ll.iterator();
		while(it.hasNext())
		{
			System.out.println(it.next().toString());
		}
	}

}
