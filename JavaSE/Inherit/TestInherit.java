//TestInherit.java

public class TestInherit
{
	public static void main(String args[])
	{
		Student student = new Student();
		student.setName("JOhn");
	}
}

class Person
{
	private String name;
	private int age;
	
	public Person()
	{
		System.out.println("I'm a person.");
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public void setAge(int age)
	{
		this.age = age;
	}
	
	public String getName()
	{
		return name;
	}
	
	public int getAge()
	{
		return age;
	}
}

class Student extends Person
{
	private String school;
	
	public Person()
	{
		System.out.println("I'm a student.");
	}
	
	public String getSchool()
	{
		return school;
	}
	
	public void setSchool(String school)
	{
		this.school = school;
	}
	
}