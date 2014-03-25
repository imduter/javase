//二分查找法
//搜索算法建立在排好序的基础之上

public class TestBinarySearch
{
	public static void main(String args[])
	{
		int arr[] = {1, 3, 4, 5, 6, 8, 9, 10, 12, 18};
		int n = 10;
		
		int location = binarySearch(arr, n);
		System.out.println(location);
	}
	
	static int binarySearch(int arr[], int n)
	{
		if(arr.length <= 0)	return -1;
		
		int head = 0;
		int tail = arr.length - 1;
		int middle = (head + tail)/2;
		
		while(head <= tail)
		{
			if(n == arr[middle])	return middle;
			if(n < arr[middle])
			{
				tail = middle - 1;
			}
			if(n > arr[middle])
			{
				head = middle + 1;
			}
			middle = (head + tail)/2;
		}
		return -1;
	} 
}