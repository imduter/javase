package com.zcloud.reflect;

import java.lang.reflect.Field;


/**
 * 
 * ����������Ա������String���͵�a��Ϊb
 * 
 * */
public class ReflectFieldDemo1 
{

	public static void main(String[] args) throws Exception
	{
		
		Class c = Test.class;
		Test t = new Test();
		
		System.out.println("ǰ�� " + t.toString());
		Field fs[] = c.getDeclaredFields();
		for(Field f : fs)
		{
			//������ͣ��Ƿ����String�������ͣ���ͬһ���ֽ�����==������equals��
			if(f.getType() == String.class)
			{
				String oldV = (String) f.get(t);
				String newV = oldV.replace('a', 'b');
				f.set(t, newV);
			}
		}

		System.out.println("��: " + t.toString());
		
	}

}

class Test
{
	@Override
	public String toString() 
	{
		return str + "\n" + str1 + "\n" + str2;
	}
	
	String str = "abc";
	String str1 = "add";
	String str2 = "apple";

}