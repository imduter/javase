//����ھ�
//	ð��·����-���룩�⣨ϣ������飨�鲢���򣩶ѣ�������
public class ArraySortE
{
	public static void main(String args[])
	{
		int n[] = {9, 8, 7, 6, 5, 4 ,3, 2, 1};
		bubbleSort(n);
		print(n);
		selectSort(n);
		print(n);
	}
	
	private static void bubbleSort(int n[])
	{
		int tmp = 0;
		//��㣺ð�ݴ���
		for(int i = 0; i < n.length - 1; i++)
		{
			//�ڲ㣺ð��һ�Σ�����������
			for(int j = 0; j < n.length -1-i; j++)
			{
				if(n[j] > n[j+1])
				{
					tmp = n[j];
					n[j] = n[j+1];
					n[j+1] = tmp;
				}
			}
		}
	}
	
	private static void selectSort(int n[])
	{
		int tmp = 0;
		//���:���ν���һ��,�ڶ���...ѡ����
		//�ڲ�:����ÿ������Ƚ�
		for(int i = 0; i < n.length; i++)
		{
			for(int j = i; j < n.length - i; j++)
			{
				if(n[i] > n[j])
				{
					tmp = n[i];
					n[i] = n[j];
					n[j] = tmp;
				}
			}
		}
	}
	
	private static void print(int n[])
	{
		for(int i = 0; i < n.length; i++)
		{
			System.out.print(n[i] + ", ");
		}
		System.out.println();
	}
}