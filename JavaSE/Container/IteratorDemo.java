//IteratorDemo.java
//������
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
			//next()�ķ���ֵΪObject����
			Name n = (Name)i.next();
			System.out.println(n.getFirstName() + "");//���ؽ��û���κ�ѭ��
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