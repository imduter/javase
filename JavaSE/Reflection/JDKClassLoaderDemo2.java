//层次关系：AppClassLoader---ExtClassLoader

public class JDKClassLoaderDemo2
{

	public static void main(String args[])
	{
		ClassLoader c = JDKClassLoaderDemo2.class.getClassLoader();
		while(c != null)
		{
			System.out.println(c.getClass().getName());
			//非继承，而是层次关系
			c = c.getParent();
		}
	}

}