//TCPServer.java

import java.net.*;
import java.io.*;


public class TCPServer
{
	public static void main(String args[])
	{
		try
		{
			ServerSocket ss = new ServerSocket(6666);
			while(true)
			{
				Socket s = ss.accept();
				OutputStream os = s.getOutputStream();
				DataOutputStream dos = new DataOutputStream(os);
				dos.writeUTF("Hello" + s.getInetAddress() + ":" + s.getPort() + "bye-bye");
				dos.flush();
				dos.close();
				s.close();
			}
		}
		catch(IOException e)
		{
			e.printStackTrace();
			System.out.println("程序运行出错：" + e);
		}
	}
}