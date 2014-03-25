//TestFileOutputStream.java

import java.io.*;

public class TestFileOutputStream  
{
	public static void main(String args[]) 
	{
		int b = 0;
		FileInputStream in = null;
		FileOutputStream out = null;
		try
		{
			in  = new FileInputStream("E:/javaws/io/1.txt");
			out = new FileOutputStream("E:/javaws/io/1cp.txt");
			while((b = in.read()) != -1)
			{
				out.write(b);
			}
			in.close();
			out.close();
		}
		catch (FileNotFoundException e1)
		{
			System.out.println("找不到指定文件");
			System.exit(-1);
		}
		catch(IOException e2)
		{
			System.out.println("文件复制错误。");
			System.exit(-1);
		}
	System.out.println("文件已复制。");
	}
}
