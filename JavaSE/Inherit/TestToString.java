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
	//��дObject�ķ�����
	public String toString()
	{
		return "I'm a cool dog.";
	}
}
