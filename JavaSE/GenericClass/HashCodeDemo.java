import java.util.ArrayList;
import java.util.Iterator;

/**
 * 
 */

/**
 * @author:	zcloud
 *
 * @description: TODO
 *
 * @date: 2013��10��16��
 *
 */
public class HashCodeDemo
{
	public static void main(String args[])
	{
		String str1 = "http://www.ifanr.com/feed";
		String str2 = "http://www.myfeed.com/feed";
		long n1 = 912663483;
		long n2 = 1548504039;
//		�Աȣ�
//		912663483
//		1548504039

		System.out.println("�Աȣ�");
		HashCodeDemo T = new HashCodeDemo();
		Iterator i = T.in().iterator();
		while(i.hasNext())
		{
			String s = (String) i.next();
			System.out.println(s.hashCode());
		}
		//48690
//		48690
	}
	
	private ArrayList<String> in()
	{
		ArrayList<String> strs = new ArrayList<String>();
		
		String str3 = "http://www.ifanr.com/feed";
		String str4 = "http://www.myfeed.com/feed";
		strs.add(str3);
		strs.add(str4);
		return strs;
	}
}
