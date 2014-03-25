package com.zcloud.reflect;


/*��ø��ֽ����Ӧ��ʵ�����

1.	��.class
2.	����.getClass();
3.	Class.forName("��");
	��֮��ÿ�����Ͷ��ж�Ӧ���� ��void��int...
	������ǽ�Java���еĸ��ֳɷ�ӳ�䵽��ӦJava���ࡣ
*/
public class ReflectDemo
{

	public static void main(String args[])
	{
		String str = "abc";
		Class c3 = null;
		
		Class c1 = str.getClass();
		Class c2 = String.class;
		try
		{
			c3 = Class.forName("java.lang.String");
		}
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		}
		
		System.out.println(c1 == c2 && c1 == c3 && c2 == c3);
		
		Class c4 = int.class;
		Class c5 = Integer.class;
		
		System.out.println(c4 == c5);
		
		Class c6 = Integer.TYPE;
		System.out.println(c4 == c6);
		
		Class c7 = int[].class;
		//�ж��Ƿ��ǻ�����
		System.out.println(c7.isPrimitive());
	}
	
}
