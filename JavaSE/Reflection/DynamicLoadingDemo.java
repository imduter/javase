public class DynamicLoadingDemo
{
	public static void main(String args[])
	{
		//������һ�ν����������
		//�����õ���ʱ���ټ���.
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
	//��̬����,�ڼ��غ�ִ��һ��
	static
	{
		System.out.println("CCCCCCCCCCCCCCCCCCCCCCCC");
	}
}

class D
{
	//��̬����,ÿ��new�����󶼻ᱻִ��
	//�൱�ڹ������е����
	//�õĽ���
	{
		System.out.println("DDDDDDDDDDDDDDDDDDDDDDDD");
	}
}