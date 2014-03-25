//TalkClient.java

import java.net.*;
import java.io.*;
import java.util.*;

public class TalkClient
{
	static OutputStream os;
	static Socket s;
	static DataOutputStream dos;
	
	public static void main(String args[])
	{
		try
		{
			Scanner sc = new Scanner(System.in);
			while(true)
			{
			//每次都new一个Socket对象出来，浪费内存。解决见chat project
				s = new Socket("127.0.0.1", 6553);
				os = s.getOutputStream();
				dos = new DataOutputStream(os);
				String str = sc.nextLine();
				if(str.equals("bye"))	break;
				dos.writeUTF(str);
				dos.flush();
			}
			dos.close();
			s.close();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
}