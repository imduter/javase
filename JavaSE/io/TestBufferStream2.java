//TestBufferStream2.java

import java.io.*;


public class TestBufferStream2
{
	public static void main(String args[])
	{
		int c = 0;

		try
		{
			BufferedWriter bw = new BufferedWriter(new FileWriter("D:/Hello.java"));
			BufferedReader br = new BufferedReader(new FileReader("D:/Hello.java"));
			String s = null;

			for(int i = 0; i <= 100; i++)
			{
				s = String.valueOf(Math.random());
				bw.write(s);
				bw.newLine();
			}
			bw.flush();
			while((s = br.readLine()) != null)
			{
				System.out.print(s);
			}
		bw.close();
		br.close();
		}

		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}