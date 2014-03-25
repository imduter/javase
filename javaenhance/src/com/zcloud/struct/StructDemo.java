package com.zcloud.struct;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Properties;
public class StructDemo 
{
	public static void main(String args[])
	{
		InputStream is = null;
		
		try 
		{
			is = new FileInputStream("S");
			Properties props = new Properties();
			props.load(is);
			String className = props.getProperty("className");
		}
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		finally
		{
			try 
			{
				is.close();
			}
			catch (IOException e) 
			{
				e.printStackTrace();
			}
		}
		
	}
}
