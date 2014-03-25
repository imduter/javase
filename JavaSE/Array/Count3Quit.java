//数三退一

/**
	对变量的捕捉，人还在圈里否？
	boolean类型变量。
*/
public class Count3Quit
{
	public static void main(String args[])
	{
		
		boolean arr[] = new boolean[500];
		int leftPerson = arr.length;
		//记数器
		int counter = 0;
		
		
		//初始化
		for(int i = 0; i < arr.length; i++)
		{
			arr[i] = true;
		}
		
		int index = 0;
		while(leftPerson > 1)
		{
			//人存在才数
			if(arr[index] == true)
			{
				counter++;
				if(counter == 3)
				{
					arr[index] = false;
					leftPerson--;
					//计数器归零
					counter = 0;
				}
			}
			index++;
			if(index == arr.length)
			{
				index = 0;
			}
		}
		
		for(int i = 0; i < arr.length; i++)
		{
			if(arr[i] == true)
			{
				System.out.println(i);
			}
		}
	}
}