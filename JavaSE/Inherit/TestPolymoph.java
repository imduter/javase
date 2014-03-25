//TestPolymoph.java---��̬��
/**
��̬�Ĵ��ڡ�
1.Ҫ�м̳�
2.Ҫ����д
3.Ҫ�и������ָ���������
java�ĺ���--------����չ��
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
		//Hook(����)CallBack(�ص�)
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
		System.out.println("����������");
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
		System.out.println("è����������");
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
		System.out.println("������������");
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
		System.out.println("�����������");
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