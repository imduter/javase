//TCPServerDemo.java
import java.net.*;
import java.io.*;

public class TCPServerDemo
{
	public static void main(String args[]) throws Exception
	{
		//阻塞式，等待客户端连接，在8888端口建立监听
		ServerSocket ss = new ServerSocket(8888);
		while(true)
		{
			Socket s = ss.accept();
			//拿到输入个管道。
			DataInputStream dis = new DataInputStream(s.getInputStream());
			//阻塞式读法
			System.out.println(dis.readUTF());
			dis.close();
			s.close();
		}
	}

}