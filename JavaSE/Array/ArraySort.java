public class ArraySort
{
	public static void main(String args[])
	{
		int n[] = new int[args.length];
		for(int i = 0; i < args.length; i++)
			n[i] = Integer.parseInt(args[i]);
		print(n);
		System.out.println("ѡ������" + " ");
		selectionSort(n);
		print(n);
		System.out.println("���ٽ���������ѡ������" + " ");
		selectionBetterSort(n);
		print(n);
	}
	
	private static void selectionSort(int n[])
	{
		//���ѭ���������е�ÿ��Ԫ��ȡ���������ÿһ��Ԫ�أ�ͨ���ڲ�ѭ�����Ƚϣ��õ���С�ģ�������
		//��������������
		//����������n-1+n-2+ ...+ 1 = (n-1)*(n-2)/2 Լ����n^2
		for(int i = 0; i < n.length; i++)
			for(int j = i+1; j < n.length; j++)
				if(n[i] > n[j])
				{
					int tmp = n[i];
					n[i] = n[j];
					n[j] = tmp;
				}
	}
	
	private static void selectionBetterSort(int n[])
	{
	/*	int belower = n[0];
		int j = 1;
	*/
		int k = 0,tmp = 0;
		for(int i = 0; i < n.length; i++)
		{
	/*		for(; j < n.length; j++)
			{
				if(belower > n[j])
				{
					belower = n[j];
				}
			}
			int temp = n[i];
			n[i] = n[j];
			n[j] = temp;
		}
		����Խ�磬����λ�õĽ�����������λ���ϵ�ֵ������
	*/		k = 1;
			for(int j = k+1; j < n.length; j++)
			{
				if(n[k] > n[j])
				{
					k = j;
				}
			}
			if(k != i)
			{
				tmp = n[i];
				n[i] = n[k];
				n[k] = tmp;
			}
		}
	}
	
	private static void print(int n[])
	{
		for(int i =  0; i < n.length; i++)
		{
			System.out.print(n[i] + " ");
		}
		System.out.println();
	}
	
}