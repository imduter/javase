//TCPServerDemo.java
import java.net.*;
import java.io.*;

public class TCPServerDemo
{
	public static void main(String args[]) throws Exception
	{
		//����ʽ���ȴ��ͻ������ӣ���8888�˿ڽ�������
		ServerSocket ss = new ServerSocket(8888);
		while(true)
		{
			Socket s = ss.accept();
			//�õ�������ܵ���
			DataInputStream dis = new DataInputStream(s.getInputStream());
			//����ʽ����
			System.out.println(dis.readUTF());
			dis.close();
			s.close();
		}
	}

}