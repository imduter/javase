public class JDKClassLoaderDemo
{

	public static void main(String args[])
	{
		System.out.println(String.class.getClassLoader());
		System.out.println(com.sun.crypto.provider.DESKeyFactory.class.getClassLoader().getClass().getName());
		System.out.println(JDKClassLoaderDemo.class.getClassLoader().getClass().getName());
		System.out.println(ClassLoader.getSystemClassLoader().getClass().getName());
	}
	
}
