//CollectionDemo.java

import java.util.*;

public class CollectionDemo
{
	public static void main(String args[])
	{
		Collection c = new ArrayList(); //��������ָ���������
										//���Է��벻ͬ���͵Ķ���
		c.add("hello");
		c.add(new Name("f1", "l1"));
		c.add(new Integer(100));
		System.out.println(c.size());
		System.out.println(c);
	}
}
/**
	��������3
			  [hello, f1, l1, 100]


*/

class Name
{
	private String firstName, lastName;
	public Name(String firstName, String lastName)
	{
		this.firstName = firstName;
		this.lastName = lastName;
	}
	public String getFristName()
	{
		return firstName;
	}
	public String getLastName()
	{
		return lastName;
	}
	public String toString()
	{
		return firstName + "" + lastName; 
	}
}