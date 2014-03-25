package com.zcloud.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ReflectConstructorDemo 
{

	public static void main(String[] args) throws Exception
	{
		Class c1 = String.class;
		Constructor constructor[] = c1.getConstructors();

		for(int i = 0 ; i < constructor.length; i++)
		{
			System.out.println(constructor[i]);
		}
		
		//Ҫ����ĸ����췽��������Class
		Constructor con = c1.getConstructor(StringBuffer.class);
		//δ���룬��Ҫָ������
		String str = (String) con.newInstance(new StringBuffer("abc"));
		System.out.println(str.charAt(1));
	}
	
}
