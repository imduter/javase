//TCPClientDemo.java
import java.net.*;
import java.io.*;

public class TCPClientDemo
{
	public static void main(String args[]) throws Exception
	{
		//��������
		Socket s = new Socket("127.0.0.1", 8888);
		//�õ�����ܵ�
		OutputStream os = s.getOutputStream();
		DataOutputStream dos = new DataOutputStream(os);
		//��ܵ�д����
		dos.writeUTF("Hello server!");
		dos.flush();
		dos.close();
		s.close();
	}
	
}