/**
	1.����ַ����д�д��ĸ����Сд��ĸ�����Լ���Ӣ����ĸ��
	2.����ַ����У�ָ���ַ��ĳ��ִ���

*/
public class TestString
{
	public static void main(String args[])
	{
		String str = "java sun JN:NF:Dkja1223434098jkfsdjflkj$##@#@$#$%*f94()";
		
		int lowCount = 0; 
		int upperCount = 0;
		int otherCount = 0;
		int repeatCount = 0;
		
		char c[] = str.toCharArray();
		for(int i = 0; i < c.length; i++)
		{
			if(Character.isLowerCase(c[i]))
			{
				lowCount ++;
			}
			else if(Character.isUpperCase(c[i]))
			{
				upperCount ++;
			}
			else
			{
				otherCount++;
			}
		}
		
		System.out.println("UpperCase��" + upperCount + ",LowerCase: " + lowCount + ",Other: " + otherCount 
							+ ",repeateCount: " + repeatCount);
	}
}