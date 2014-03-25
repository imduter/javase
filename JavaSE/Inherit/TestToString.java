public class TestToString
{
	public static void main(String args[])
	{
		Dog d = new Dog();
		System.out.println("d=" + d.toString());
	}
}
class Dog
{
	//重写Object的方法。
	public String toString()
	{
		return "I'm a cool dog.";
	}
}
