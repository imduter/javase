package com.appspot.zcloud;

import java.io.IOException;
import java.util.Properties;

public class PropertiesMgr
{
	private static Properties prop = new Properties();
	
	static
	{
		try 
		{
			prop.load(PropertiesMgr.class.getClassLoader().getResourceAsStream("config/tank.properties"));
		}
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
	
	public static int getProperty(String key)
	{
		return Integer.parseInt(prop.getProperty(key));
	}
}
