package com.zcloud.iterator;

public class Cat 
{	
	private int id = 0;
	
	Cat(int id)
	{
		this.id = id;
	}
	
	@Override
	public String toString()
	{
		return "Cat" + id;
	}
}
