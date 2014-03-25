//TCPClient.java

import java.net.*;
import java.io.*;

public class TCPClient
{
	public static void main(String args[])
	{
		try
		{
			Socket s = new Socket("127.0.0.1", 6666);
			DataInputStream dis = new DataInputStream(s.getInputStream());
			System.out.println(dis.readUTF());
			dis.close();
			s.close();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
}
