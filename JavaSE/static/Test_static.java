//��̬����������Զ�����ܵ��á�����̬��������Զ��󣬲��Ὣ��������ô��ݸ��������Ծ�̬�����в����Է��ʷǾ�̬��Ա������
//����ͨ���������û��������ʾ�̬��Ա��
//��̬�����Ӷ��忪ʼ�ѱ�������������
//���������ָ���Ƕ���ĵ�ַ��
public class Test_static
{
	
	public static void main(String args[])
	{
		Cat.sid = 100;//������Լ��ĳ�Ա����
		System.out.println(Cat.sid);//System.out��outΪ��̬��Ա��������Ϊ����Ҳ���Է��ʡ�
		Cat mimi = new Cat("mimi");//�ַ����������ݶ�
		Cat pipi = new Cat("pipi");
		mimi.info();
		pipi.info();
		System.out.println(mimi.sid);//���ʵ��������ĳ�Ա����
		System.out.println(pipi.sid);//static��������ݴ�������ݶ�
									//���ж�����һ��
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
		id = sid++;//�ȸ�ֵ��id���Լ�
	}
	public void info()
	{
		System.out.println("My name is "+name+" id = "+id);
	}
}
	