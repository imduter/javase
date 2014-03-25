//EmailSpider.java

import java.io.*;
import java.util.regex.*;

public class EmailSpider
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new FileReader("D:/Test.htm"));
		String line = "";
		while((line = br.readLine()) != null)
		{
			parse(line);
		}
	}
	
	private static void parse(String line)
	{
		Pattern p = Pattern.compile("[\\w[.-]]+@[\\w[.-]]+\\.[\\w]+");
		Matcher m = p.matcher(line);
		while(m.find())
		{
			System.out.println(m.group());
		}
	}
}