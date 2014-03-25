//TestBufferStream1.java

import java.io.*;

public class TestBufferStream1
{
	public static void main(String[] args) 
	{
		try
		{
			FileInputStream fis = new FileInputStream("D:/Hello.txt");
			BufferedInputStream bis = new BufferedInputStream(fis);
			int c = 0;
			//依次读取第一第二个字节。
			System.out.println((char)bis.read());
			System.out.println((char)bis.read());
			System.out.println("---------------");
			bis.mark(5);
			for(int i = 0; i <= 8 && (c = bis.read()) != -1; i ++)
			{
				System.out.println((char)c+" ");
			}
			System.out.println();
			bis.reset();
			for(int i = 0; i <= 10 && (c = bis.read()) != -1; i ++)
			{
				System.out.println((char)c+" ");
			}
			bis.close();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}
