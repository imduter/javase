//TestFileReader.java
import java.io.*;

public class TestFileReader
{
	public static void main(String[] args) 
	{
		int b = 0;

		FileReader fr = null;
		try
		{
			fr = new FileReader("E:/javaws/io/TestFileReader.java");
			while((b = fr.read()) != -1)
			{
				System.out.print((char)b);
			}
			fr.close();
		}
		catch(FileNotFoundException e)
		{
			System.out.println("�ļ������ڡ�");
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
}
