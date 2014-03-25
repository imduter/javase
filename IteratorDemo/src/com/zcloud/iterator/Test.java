package com.zcloud.iterator;

import com.zcloud.iterator.*;

/**
 * 1.面向接口编程
 * 2.容器遍历方法不同，同一实现接口。
 * 具体实现让实现接口的类去具体实现
 * 3.泛型的实现
 * 4.接口隔离原则：
 * 和其他人打交道，只需要找到相关的就行，无需知道其他。
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
