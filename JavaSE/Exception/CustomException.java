public class CustomException
{
	public static void main(String[] args)
	{
		new CustomException().manager();
	}
	
	public void regist(int num) throws MyException
	{
		if(num < 0)
		{
			throw new MyException("����Ϊ��", 0);
		}
		System.out.println("�Ǽ�����Ϊ" + num);
	}
	
	public void manager()
	{
		try
		{
			regist(100);
		}catch(MyException e)
		{
			System.out.println("�Ǽ�ʧ�ܣ�����������=" + e.getId());
		}
		System.out.println("����������");
	}
}

class MyException extends Exception
{
	private int id;
	
	public MyException(String message, int id)
	{
		super(message);
		this.id = id;
	}
	
	public int getId()
	{
		return id;
	}
}