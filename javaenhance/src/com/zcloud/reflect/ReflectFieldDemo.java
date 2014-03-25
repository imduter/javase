package com.zcloud.reflect;

import java.lang.reflect.Field;

public class ReflectFieldDemo 
{

	public static void main(String[] args) throws Exception
	{
		
		Point p = new Point(3, 5);
		Class c = p.getClass();
		Field fY = c.getField("y");
		System.out.println(fY.get(p));
		//private,���ɼ� 
//		Field fX = c.getField("x");
		Field fX = c.getDeclaredField("x");
		//�ɼ����ã��������䡣
		fX.setAccessible(true);
		System.out.println(fX.get(p));
	}

}

class Point
{

	private int x;
	public int y;

	Point(int x, int y) 
	{
		this.x = x;
		this.y = y;
	}	
	
}
