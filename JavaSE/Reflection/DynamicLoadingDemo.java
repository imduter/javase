public class DynamicLoadingDemo
{
	public static void main(String args[])
	{
		//并不是一次将所有类加载
		//而是用到的时候再加载.
		new A();
		System.out.println("=====================");
		new B();
		
		new C();
		new C();
		
		new D();
		new D();
	}
}

class A
{}

class B
{}

class C
{
	//静态语句块,在加载后执行一次
	static
	{
		System.out.println("CCCCCCCCCCCCCCCCCCCCCCCC");
	}
}

class D
{
	//动态语句块,每次new出对象都会被执行
	//相当于构造器中的语句
	//用的较少
	{
		System.out.println("DDDDDDDDDDDDDDDDDDDDDDDD");
	}
}