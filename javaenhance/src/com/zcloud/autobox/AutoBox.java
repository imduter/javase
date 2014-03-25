package com.zcloud.autobox;


/**
 * 
 * FlyWight(��Ԫģʽ)
 *1.���������С�����Դ����ͬʱʹ�á�
 * 
 * */
public class AutoBox
{

	public static void main(String args[])
	{
		
		//�Զ�װ��
		Integer i1 = 1;
		Integer i2 = 2;
		 
		//�Զ�����
		System.out.println(i1 + i2);
		
		//����
		String str1 = new String("abc");
		String str2 = new String("abc");
		
		Integer i3 = 3;
		Integer i4 = 3;
		System.out.println(i3 == i4);
		
		Integer i5 = 197;
		Integer i6 = 197;
		System.out.println(i5 == i6);

		Integer i7 = Integer.valueOf(197);
		Integer i8 = Integer.valueOf(197);
		System.out.println(i7 == i8);
	}
	
}
