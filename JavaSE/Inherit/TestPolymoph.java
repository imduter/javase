//TestPolymoph.java---动态绑定
/**
多态的存在。
1.要有继承
2.要有重写
3.要有父类对象指向子类对象
java的核心--------可扩展性
*/
public class TestPolymoph
{
	public static void main(String args[])
	{
		Cat c = new Cat("catname", "black");
		Dog d = new Dog("dogname", "blue");
		//Bird b = new Bird();
		Lady l1 = new Lady("l1", c);
		Lady l2 = new Lady("l2", d);
		//Lady l3 = new Lady("l3", b);
		//Hook(钩子)CallBack(回掉)
		l1.myPetEnjoy();
		l2.myPetEnjoy();
		//l3.myPetEnjoy();
	}
}

class Animal
{
	private String name;
	Animal(String name)
	{
		this.name = name;
	}
	public void enjoy()
	{
		System.out.println("叫声。。。");
	}
}

class Cat extends Animal
{
	private String eyesColor;
	Cat(String n, String c)
	{
		super(n);
		eyesColor = c;
	}
	public void enjoy()
	{
		System.out.println("猫叫声。。。");
	}
}

class Dog extends Animal
{
	private String furColor;
	Dog(String n, String c)
	{
		super(n);
		furColor = c;
	}
	public void enjoy()
	{
		System.out.println("狗叫声。。。");
	}
}

/*
class Bird extends Animal
{
	Bird()
	{
		super("bird");
	}
	public void enjoy()
	{
		System.out.println("鸟叫声。。。");
	}
}
*/
class Lady
{
	private String name;
	private Animal pet;
	Lady(String name, Animal pet)
	{
		this.name = name;
		this.pet = pet;
	}
	public void myPetEnjoy()
	{
		pet.enjoy();
	}
}