package com.zcloud.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectMethod 
{

	public static void main(String[] args) 
	{
		
		try 
		{
			String str = "abc";
			Method methodCharAt = String.class.getMethod("charAt", int.class);
			try
			{
				System.out.println(methodCharAt.invoke(str, 1));
			} catch (IllegalAccessException | IllegalArgumentException
					| InvocationTargetException e) 
			{
				e.printStackTrace();
			}
		}
		catch (NoSuchMethodException e) 
		{
			e.printStackTrace();
		} catch (SecurityException e) 
		{
			e.printStackTrace();
		}
	}

}
