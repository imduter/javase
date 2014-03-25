public class ArraySort
{
	public static void main(String args[])
	{
		int n[] = new int[args.length];
		for(int i = 0; i < args.length; i++)
			n[i] = Integer.parseInt(args[i]);
		print(n);
		System.out.println("选择排序" + " ");
		selectionSort(n);
		print(n);
		System.out.println("减少交换次数的选择排序" + " ");
		selectionBetterSort(n);
		print(n);
	}
	
	private static void selectionSort(int n[])
	{
		//外层循环将数组中的每个元素取出与其后面每一个元素（通过内层循环）比较，得到最小的，交换。
		//最坏情况：倒序排列
		//交换次数：n-1+n-2+ ...+ 1 = (n-1)*(n-2)/2 约等于n^2
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
		数组越界，考虑位置的交换，而不是位置上的值交换。
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