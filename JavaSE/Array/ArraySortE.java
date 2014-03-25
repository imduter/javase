//排序口诀
//	冒择路（入-插入）兮（希尔）快归（归并排序）堆（堆排序）
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
		//外层：冒泡次数
		for(int i = 0; i < n.length - 1; i++)
		{
			//内层：冒泡一次，相邻数交换
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
		//外层:依次将第一个,第二个...选出来
		//内层:其后的每个与其比较
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