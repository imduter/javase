//动态方法必须针对对象才能调用。而静态方法不针对对象，不会将对象的引用传递给他，所以静态方法中不可以访问非静态成员变量。
//可以通过对象引用或类名访问静态成员。
//静态变量从定义开始已被分配与数据区
//对象的引用指的是对象的地址。
public class Test_static
{
	
	public static void main(String args[])
	{
		Cat.sid = 100;//类访问自己的成员变量
		System.out.println(Cat.sid);//System.out中out为静态成员变量，因为其类也可以访问。
		Cat mimi = new Cat("mimi");//字符串存于数据段
		Cat pipi = new Cat("pipi");
		mimi.info();
		pipi.info();
		System.out.println(mimi.sid);//类的实例访问类的成员变量
		System.out.println(pipi.sid);//static定义的数据存放于数据段
									//所有对象共享一份
		mimi.sid = 100;
		System.out.println(mimi.sid);
		System.out.println(pipi.sid);
	}
}	
class Cat
{
	static int sid = 0;
	private String name;
	int id;
	Cat(String name)
	{
		this.name = name;
		id = sid++;//先赋值给id再自加
	}
	public void info()
	{
		System.out.println("My name is "+name+" id = "+id);
	}
}
	