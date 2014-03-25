//TalkServer.java

import java.net.*;
import java.io.*;

public class TalkServer
{
	public static void main(String args[])
	{
		Socket s = null;
		DataInputStream dis = null;
		
		try
		{
			ServerSocket ss = new ServerSocket(6553);
			while(true)
			{
				s = ss.accept();
				dis = new DataInputStream(s.getInputStream());
				String str = dis.readUTF();
				if(str.equals("bye"))	break;
				System.out.println(str);
			}
			dis.close();
			s.close();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
	}
}