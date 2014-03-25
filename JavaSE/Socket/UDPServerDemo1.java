//UDPServerDemo1.java

import java.net.*;
import java.io.*;

public class UDPServerDemo1
{
	public static void main(String args[]) throws Exception
	{
		//实际用来存储接受到的数据包
		byte buf[] = new byte[1024];
		//用来存放接受到的数据包
		DatagramPacket dp = new DatagramPacket(buf, buf.length);
		//用于监听8888端口是否有数据包传来
		DatagramSocket ds = new DatagramSocket(8888);
		while(true)
		{
			//阻塞式接受, 将收到的数据包存到dp里
			ds.receive(dp);
			//传递字节数组的输入管道，将实际存的字节数组放入此管道
			ByteArrayInputStream bais = new ByteArrayInputStream(buf);
			//将传递字节数组的输入管道，在包装成数据输入管道，以便将数据作为long类型读出。
			DataInputStream dis = new DataInputStream(bais);
			//逮到数据输出管道，读数据
			Long num = dis.readLong();
			
			System.out.println(num);
		}
		dis.close();
		ds.close();
	}
}