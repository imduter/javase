//TCPClientDemo.java
import java.net.*;
import java.io.*;

public class TCPClientDemo
{
	public static void main(String args[]) throws Exception
	{
		//申请连接
		Socket s = new Socket("127.0.0.1", 8888);
		//拿到输出管道
		OutputStream os = s.getOutputStream();
		DataOutputStream dos = new DataOutputStream(os);
		//向管道写东西
		dos.writeUTF("Hello server!");
		dos.flush();
		dos.close();
		s.close();
	}
	
}