import java.lang.reflect.Method;

public class TestReflection
{

	public static void main(String args[]) throws Exception
	{
		String str = "T";
		Class c = Class.forName(str);
		c.newInstance();
		Method methods[] = c.getMethods();
		for(Method m : methods)
		{
			System.out.println(m.getName());
			// if(m.getName().equls("mm"))
			// {
				// m.invoke();
			// }
		}
	}
	
}

class T
{

	static 
	{
		System.out.println("T loaded!");
	}
	
	public T()
	{
		System.out.println("T constructed!");
	}
	
	int i;
	String s;
	
	public void m1(int i)
	{
		this.i = i;
	}
	
	public void mm()
	{
		System.out.println("m invoked.");
	}
	
}