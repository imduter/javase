//������һ

/**
	�Ա����Ĳ�׽���˻���Ȧ���
	boolean���ͱ�����
*/
public class Count3Quit
{
	public static void main(String args[])
	{
		
		boolean arr[] = new boolean[500];
		int leftPerson = arr.length;
		//������
		int counter = 0;
		
		
		//��ʼ��
		for(int i = 0; i < arr.length; i++)
		{
			arr[i] = true;
		}
		
		int index = 0;
		while(leftPerson > 1)
		{
			//�˴��ڲ���
			if(arr[index] == true)
			{
				counter++;
				if(counter == 3)
				{
					arr[index] = false;
					leftPerson--;
					//����������
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