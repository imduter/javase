//TestFileWriter.java

import java.io.*;

public class TestFileWriter
{
 	public static void main(String[] args) 
	{
		int b = 0;
		FileWriter fw = null;

		try
		{	
			fw = new FileWriter("D:/bak/Testfw.bat");

			for(int c = 0; c <= 6553; c++)
 			{
				fw.write(c);	
			}
			fw.close();
		}
		catch (IOException e)
		{
			e.printStackTrace();
			System.out.println("Ð´Èë´íÎó¡£");
			System.exit(-1);
		}
	}
}
