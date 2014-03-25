import java.io.*;
import java.util.regex.*;

public class EmailSelection
{
	
	public static void main(String args[]) throws Exception
	{
			FileReader fr = new FileReader("D:/Test.htm");
			BufferedReader br = new BufferedReader(fr);
			
			Pattern p = Pattern.compile("[\\w[.-]]+@[\\w[.-]]+\\.[\\w]+");
			String str = null;
			
			while((str = br.readLine()) != null)
			{
				Matcher m = p.matcher(str);
				if(m.find())
				{
					System.out.println(m.group());
				}
			}
	}
}