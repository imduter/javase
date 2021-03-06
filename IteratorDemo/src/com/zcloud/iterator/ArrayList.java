package com.zcloud.iterator;

/**
 * 简单地模拟ArrayList
 * 
 * */

//所谓E指element

public class ArrayList implements Collection
{
	private Object objects[] = new Object[10];
	private int size = 0;
	
	
	public void add(Object o)
	{
		if(size == objects.length)
		{
			Object newObjects[] = new Object[objects.length * 2];
			System.arraycopy(objects, 0, newObjects, 0, objects.length);
			objects = newObjects;
		}
		objects[size] = o;
		size++;
	}

	public int size()
	{
		return size;
	}
	
	public Iterator iterator()
	{
		return new ArrayListIterator();
	}
	
	private class ArrayListIterator implements Iterator
	{
		int currentIndex = 0;

		@Override
		public boolean hasNext()
		{
			if(currentIndex >= size)	return false;
			else return true;
		}

		@Override
		public Object next() 
		{
			Object o = objects[currentIndex];
			currentIndex ++;
			return o;
		}
		
	}
}
