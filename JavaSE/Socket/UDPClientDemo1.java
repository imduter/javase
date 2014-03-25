//UDPClientDemo1.java

import java.net.*;
import java.io.*;

public class UDPClientDemo1
{
	public static void main(String args[]) throws Exception
	{
		Long num = 1000L;
		//定义用于输出字节数组的管道
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		//将输出字节数组的管道包装为数据输出管道
		DataOutputStream dos = new DataOutputStream(baos);
		//逮到数据输出管道往里写数据
		dos.writeLong(num);
		
		//逮到字节数组输出管道，将里面的字节数组拿出，放入字节数组
		byte buf[] = baos.toByteArray();
		//包含指定地址，以及字节数组数据的数据包
		DatagramPacket dp = new DatagramPacket(buf, buf.length, new InetSocketAddress("127.0.0.1", 8888));
		//数据包端口用于发送数据包
		DatagramSocket ds = new DatagramSocket(7777);
		ds.send(dp);
		dos.close();
		ds.close();
	}
}