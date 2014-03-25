package com.zcloud.autobox;


/**
 * 
 * �ɱ����...
 * 
 * */
public class VarableParameter
{
	
	public static void main(String args[])
	{
		System.out.println(add(3, 4));
		System.out.println(add(2, 4, 5));
	}
	
	
	//������Ĭ�ϴ���һ������,�ڷ����������������ʽ����.
	private static int add(int x, int...args)
	{
		for(int i = 0; i < args.length; i++)
		{
			x += args[i];
		}
		return x;
	}
	
}