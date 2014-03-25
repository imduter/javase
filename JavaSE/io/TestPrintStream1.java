//TestPrintStream1.java

import java.io.*;

public class TestPrintStream1
{
	public static void main(String args[])
	{
		PrintStream ps = null;
		try
		{
			FileOutputStream fos = new FileOutputStream("D:/bak/Hello.java");
			ps = new PrintStream(fos);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		if(ps != null)
		{
			System.setOut(ps);//并未如马老师所说，Out指向ps
		}
		int ln = 0;
		for(char c = 0; c <= 60000; c++)
		{
			System.out.print(c+" ");
			if(ln++ >= 100)
			{
				System.out.println();
				ln = 0;
			}
		}
	}
}