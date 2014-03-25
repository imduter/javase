/**
	java.lang.StringBuffer代表可变的字符序列
*/

public class TestStringBuffer
{
	public static void main(String args[])
	{
		String s = "Microsoft";
		char[] a = {'a', 'b', 'c'};

		StringBuffer sb1 = new StringBuffer(s);
		sb1.append('/').append("IBM");
		System.out.println(sb1);
		
	}
	
}