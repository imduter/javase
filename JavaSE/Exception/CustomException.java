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
			throw new MyException("人数为负", 0);
		}
		System.out.println("登记人数为" + num);
	}
	
	public void manager()
	{
		try
		{
			regist(100);
		}catch(MyException e)
		{
			System.out.println("登记失败，错误类型码=" + e.getId());
		}
		System.out.println("操作结束！");
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