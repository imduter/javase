//IteratorDemo.java
//迭代器
import java.util.*;

public class IteratorDemo
{
	public static void main(String args[])
	{
		Collection c = new HashSet();
		c.add(new Name("f1", "l1"));
		c.add(new Name("f2", "l2"));
		c.add(new Name("f3", "l3"));
		Iterator i = c.iterator();
		while(i.hasNext())
		{
			//next()的返回值为Object类型
			Name n = (Name)i.next();
			System.out.println(n.getFirstName() + "");//返回结果没有任何循序。
		}
	}
}

class Name
{
	String firstName, lastName;
	public Name(String firstName, String lastName)
	{
		this.firstName = firstName;
		this.lastName = lastName;
	}
	public String getFirstName()
	{
		return firstName;
	}
	public String getLastName()
	{
		return lastName;
	}
}