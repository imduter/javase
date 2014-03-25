//TestTransForm1.java
//此代码运行时出错。
import java.io.*;

public class TestTransForm1
{
	public static void main(String[] args) 
	{
		try
		{
			OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("D:/Hello.java"));
			osw.write("HaHaHaHa\nHaHaHa");
			System.out.println(osw.getEncoding());
			osw.close();
			osw = new OutputStreamWriter(new FileOutputStream("D:/Hello.java", true), "ISO8895_1");
			osw.write("HaHaHaHa\nHaHaHa");
			System.out.println(osw.getEncoding());
			osw.close();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}

	}
}
