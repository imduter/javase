/**
*TestFileInputStream.java
*
*/

import java.io.*;

public class TestFileInputStream
{
	public static void main(String args[])
	{
		int b = 0;
		FileInputStream in = null;
		try
		{
			in = new FileInputStream("E:\\javaws\\io\\TestFileInputStream.java");
		}
		catch (FileNotFoundException e)
		{
			System.out.println("�ļ�û���ҵ���");
			System.exit(-1);
		}
		try
		{
			long num = 0;

			while((b = in.read()) != -1)
			{
				System.out.print((char)b);
				num++;
			}
			in.close();
			System.out.println("����ȡ��"+num+"�ֽ�");
		}
		catch (IOException e1)
		{
			System.out.println("�ļ���ȡ����");
			System.exit(-1);
		}
	}
}