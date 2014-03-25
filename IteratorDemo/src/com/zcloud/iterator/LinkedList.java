package com.zcloud.iterator;

/**
 * LinkedList的模拟
 * 
 * */
public class LinkedList implements Collection
{
	private int size = 0;
	private Node head;
	private Node tail;
	
	public void add(Object o)
	{
		Node n = new Node(o, null);
		if(head == null)
		{
			head = n;
			tail = n;
		}
		tail.next = n;
		tail = n;
		size++;
	}
	
	public int size()
	{
		return size;
	}
	
	public Iterator iterator()
	{
		return new LinkedListIterator();
	}
	
	private class LinkedListIterator implements Iterator
	{
		
		@Override
		public boolean hasNext()
		{
			if(head == null)	return false;
			else	return true;
		}

		@Override
		public Object next() 
		{
			Object o = head.getData();
			head = head.next;
			return o;
		}
		
	}
}

class Node
{
	//描述数据本身
	//Node data;
	Object data;
	//指向下一个数据
	Node next;

	Node(Object data, Node next)
	{
		this.data = data;
		this.next = next;
	}

	Object getData() {
		return data;
	}

	void setData(Object data) {
		this.data = data;
	}

}