//TestArgsWords.java

import java.util.*;

public class TestArgsWords
{
	//private static fianl Integer ONE = new Integer(1);
	private static final Integer ONE = 1;//自动打包

	public static void main(String args[])
	{
		Map m = new HashMap();
		for(int i = 0; i< args.length; i++)
		{
			//Integer freq = (Integer)m.get(args[i]);
			int freq = (Integer) m.get(args[i]) == null ? 0 : (Integer) m.get(args[i]);
			//m.put(args[i], (freq == null ? ONE : new Integer(freq.intValue() + 1)));
			m.put(args[i], fraq == 0 ? ONE : freq + i);
		}
		System.out.println(m.size() + "distinct word detected:");
		System.out.println(m);
 	}
}