/**
	��дһ������������һ��doubl�͵Ķ�ά���飬
	�����е�Ԫ��ͨ�������ַ�����á�
	�磺�ַ�������"1, 2; 3, 4, 5; 6, 7, 8"
	��Ӧ������Ϊ��
	d[0][0] = 1.0
	d[0][1] = 2.0
	...
*/

public class TestDataPackage
{
	public static void main(String args[])
	{		
		String str = "1,2;3,4,5;6,7,8";
		stringDoubleArray(str);
		
	}
	
	public static void stringDoubleArray(String s)
	{
		double d[][] = new double[2][4];
		
		String str1[] = s.split("[,;]");
		
		int k = 0;
		
		for(int i = 0; i < 2; i++)
		{
			for(int j = 0; j < 4; j++)
			{
				while(k < 8)
				{
					d[i][j] = new Double(str1[k]);
					k++;
					break;
				}
			}
		}
	
		for(int i = 0; i < 2; i++)
		{
			for(int j = 0; j < 4; j++)
			{
				System.out.print(d[i][j] + ", ");
			}
		
		}
	}
}