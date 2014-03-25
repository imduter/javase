//equals 方法
public class EqualsDemo
{
	public static void main(String args[])
	{
		Cat c1 = new Cat(1, 3, 5);
		Cat c2 = new Cat(1, 3, 5);
		
		System.out.println("==\n:" + (c1 == c2));
		System.out.println("==\n:" + c1.equals(c2));
	}
}

class Cat
{
	int color;
	int height;
	int weight;
	
	public Cat(int color, int height, int weight)
	{
		this.color = color;
		this.height = height;
		this.weight = weight;
	}
	
	public boolean equals(Object obj)
	{
		if(obj == null)
			return false;
		else
		{
			if(obj instanceof Cat)
			{
				Cat c = (Cat)obj;
				if(c.color == this.color && c.height == this.height && c.weight == this.weight)
				  //被比较对象的颜色 //比较对象的颜色。
					return true;
			}
		}
		return false;
	}
}