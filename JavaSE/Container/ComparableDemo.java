//ComparableDemo.java

import java.util.*;

public class ComparableDemo
{
	public static void main(String args[])
	{
		List l1 = new LinkedList();
		l1.add(new Name("Karl", "M"));
		l1.add(new Name("Steven", "Lee"));
		l1.add(new Name("John", "o"));
		l1.add(new Name("Tom", "M"));
		l1.add(new Name("tom", "m"));
		System.out.println(l1);
		Collections.sort(l1);
		System.out.println(l1);
	}
}

class Name implements Comparable
{
	private String firstName, lastName;
	public Name(String firstName, String lastName)
	{
		this.firstName = firstName;
		this.lastName = lastName;
	}
	public String getFirstName()
	{
		return firstName;
	}
	public String getlastName()
	{
		return lastName;
	}
	public String toString()
	{
		return firstName + " " + lastName;
	}

	public boolean equals(Object obj)
	{
		if(obj instanceof Name)//若是一个Name类
		{
			Name name = (Name) obj;
			return (firstName.equals(name.firstName) && (lastName.equals(name.lastName)));
		}
		return super.equals(obj);
	}
	public int hashCode()
	{
		return firstName.hashCode();
	}

	public int compareTo(Object o)
	{
		Name n = (Name)o;
		int lastCmp = lastName.compareTo(n.lastName);//这里String类实现了Comparable接口，先比较首字母，再比较第二个字母。。。。。
		return (lastCmp != 0 ? lastCmp : firstName.compareTo(n.firstName));
	}
}